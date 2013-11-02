package sundy.android.demo.datastore;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import sundy.android.demo.* ;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class NetworkDemo extends Activity {

	private ListView lvDataList;
	private ProgressDialog m_ProgressDialog = null;
	private List<String> m_Data = new ArrayList<String>();
	private Handler m_Handler = new Handler();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.network_demo);

		InitView();
		InitListeners();
		BindData();
	}

	private void InitView() {
		lvDataList = (ListView) findViewById(R.id.lvDataList);
	}

	private void InitListeners() {

	}

	public void BindData() {
		// 显示一个进度条
		m_ProgressDialog = ProgressDialog.show(NetworkDemo.this, "请稍等...",
				"获取信息列表...", true);

		new Thread() {
			public void run() {
				try {
					// 获取网站数据内容
					String _Content = Request("www.caoegg.cn");
					// 定义一个正则表达式，并进行数据的提取、过滤
					String _Str = "(<div class=\"c\">){1}[\\S ]+(</div>){1}";
					// 编译正则表达式
					Pattern _Pattern = Pattern.compile(_Str);
					// 返回匹配的Matcher
					Matcher _Matcher = _Pattern.matcher(_Content);
					_Content = "";
					// 遍历Matcher，取匹配的数据
					while (_Matcher.find()) {
						String _Tmp = _Matcher.group();
						_Content += _Tmp + "\r\n";
						// 将Html数据转换为Text形式，放入List
						m_Data.add(Html2Text(_Tmp));
					}
					// 更新ListView，显示数据
					UpdateList();
					// 关闭进度条
					m_ProgressDialog.dismiss();
				} catch (Exception e) {
					Toast.makeText(NetworkDemo.this, "获取信息失败！", 1).show();
				}
			}
		}.start();
	}

	private void UpdateList() {
		m_Handler.post(new Runnable() {
			public void run() {
				// 构建一个Adapter，并且绑定Listveiw
				lvDataList.setAdapter(new ArrayAdapter<String>(
						NetworkDemo.this, android.R.layout.simple_list_item_1,
						m_Data));
			}
		});
	}

	private String Request(String p_Url) throws ClientProtocolException,
			IOException, URISyntaxException {
		//声明一个HttpClient实例
		HttpClient httpClient = new DefaultHttpClient();
		//通过URIUtils工具类声明一个Uri，帮我们组装生成Url
		URI _Uri = URIUtils.createURI("http", p_Url, -1, null, null, null);
		//声明HttpGet对象，使用Get方式获取网站数据
		HttpGet _Get = new HttpGet(_Uri);
		//用系统提供的默认的恢复策略
		ResponseHandler<String> _ResponseHandler = new BasicResponseHandler();
		//执行execute获取按指定格式获取内容
		String _Content = new String(httpClient.execute(_Get, _ResponseHandler).getBytes("ISO-8859-1"));
		return _Content;
		//HttpClient
	}
	
	public String Html2Text(String inputString) {
		String htmlStr = inputString; // 含html标签的字符串
		String textStr = "";
		java.util.regex.Pattern p_script;
		java.util.regex.Matcher m_script;
		java.util.regex.Pattern p_style;
		java.util.regex.Matcher m_style;
		java.util.regex.Pattern p_html;
		java.util.regex.Matcher m_html;

		try {
			String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; // 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
																										// }
			String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; // 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
																									// }
			String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式

			p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
			m_script = p_script.matcher(htmlStr);
			htmlStr = m_script.replaceAll(""); // 过滤script标签

			p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
			m_style = p_style.matcher(htmlStr);
			htmlStr = m_style.replaceAll(""); // 过滤style标签

			p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
			m_html = p_html.matcher(htmlStr);
			htmlStr = m_html.replaceAll(""); // 过滤html标签

			textStr = htmlStr;

		} catch (Exception e) {
			System.err.println("Html2Text: " + e.getMessage());
		}

		return textStr;// 返回文本字符串
	}
}