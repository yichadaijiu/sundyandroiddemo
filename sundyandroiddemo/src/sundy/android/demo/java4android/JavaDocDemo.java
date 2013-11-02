/**
 * @author Sundy
 * @description Hello Javadoc
 * @version 1.0
 * @date 2011-9-13
 */
package sundy.android.demo.java4android;

import java.net.URL;
import java.sql.Array;
import java.util.Observer;

import android.graphics.Bitmap;

/**
 * JavaDoc 的测试类， 只有这个类用
 * @author Sundy Zhang
 * @version 1.0
 * @date 2011-9-13
 * @since java 6
 * @description javadoc的测试类
 * {@link=http://www.sun.com"}
 *
 */
public class JavaDocDemo{

	/**
	 * Returns an Image object that can then be painted on the screen. 
	 * The url argument must specify an absolute  
	                          
	{@link URL}. The name
	 * argument is a specifier that is relative to the url argument. 
	 * <p>
	 * This method always returns immediately, whether or not the 
	 * image exists. When this applet attempts to draw the image on
	 * the screen, the data will be loaded. The graphics primitives 
	 * that draw the image will incrementally paint on the screen. 
	 *
	 *  
	                          
	@param  url  an absolute URL giving the base location of the image
	 *  
	                          
	@param  name the location of the image, relative to the url argument
	 *  
	                          
	@return the Array at the specified URL
	 *  
	                          
	@see    Array
	 */
	public Array getImage(URL url, String name) {
	        return null ;
	 }
	
	/**
	 * Graphics is the abstract base class for all graphics contexts
	 * which allow an application to draw onto components realized on
	 * various devices or onto off-screen images.
	 * A Graphics object encapsulates the state information needed
	 * for the various rendering operations that Java supports.  This
	 * state information includes:
	 * <ul>
	 * <li>The Component to draw on
	 * <li>A translation origin for rendering and clipping coordinates
	 * <li>The current clip
	 * <li>The current color
	 * <li>The current font
	 * <li>The current logical pixel operation function (XOR or Paint)
	 * <li>The current XOR alternation color
	 *     (see <a href="#setXORMode">setXORMode</a>)
	 * </ul>
	 * <p>
	 * Coordinates are infinitely thin and lie between the pixels of the
	 * output device.
	 * Operations which draw the outline of a figure operate by traversing
	 * along the infinitely thin path with a pixel-sized pen that hangs
	 * down and to the right of the anchor point on the path.
	 * Operations which fill a figure operate by filling the interior
	 * of the infinitely thin path.
	 * Operations which render horizontal text render the ascending
	 * portion of the characters entirely above the baseline coordinate.
	 * <p>
	 * Some important points to consider are that drawing a figure that
	 * covers a given rectangle will occupy one extra row of pixels on
	 * the right and bottom edges compared to filling a figure that is
	 * bounded by that same rectangle.
	 * Also, drawing a horizontal line along the same y coordinate as
	 * the baseline of a line of text will draw the line entirely below
	 * the text except for any descenders.
	 * Both of these properties are due to the pen hanging down and to
	 * the right from the path that it traverses.
	 * <p>
	 * All coordinates which appear as arguments to the methods of this
	 * Graphics object are considered relative to the translation origin
	 * of this Graphics object prior to the invocation of the method.
	 * All rendering operations modify only pixels which lie within the
	 * area bounded by both the current clip of the graphics context
	 * and the extents of the Component used to create the Graphics object.
	 * 
	 *  
	                   
	 * @author  Sundy Zhang
	 *  
	                    
	@version     V1.0
	 *  
	                    
	@since       1.0
	 */
	public abstract class Graphics {

	    /** 
	     * Draws as much of the specified image as is currently available
	     * with its northwest corner at the specified coordinate (x, y).
	     * This method will return immediately in all cases, even if the
	     * entire image has not yet been scaled, dithered and converted
	     * for the current output device.
	     * <p>
	     * If the current output representation is not yet complete then
	     * the method will return false and the indicated 
	     * {@link ImageObserver} object will be notified as the
	     * conversion process progresses.
	     *
	     *  
	                    
	@param img       the image to be drawn
	     * @param x         the x-coordinate of the northwest corner
	     *                  of the destination rectangle in pixels
	     * @param y         the y-coordinate of the northwest corner
	     *                  of the destination rectangle in pixels
	     * @param observer  the image observer to be notified as more
	     *                  of the image is converted.  May be 
	     *                  <code>null</code>
	     *  
	                    
	@return          <code>true</code> if the image is completely 
	     *                  loaded and was painted successfully; 
	     *                  <code>false</code> otherwise.
	     *  
	                    
	@see             Image
	     * @see             ImageObserver
	     *  
	                    
	@since           1.0
	     */
	    public abstract boolean drawImage(Bitmap img, int x, int y, 
	                                      Observer observer);


	    /**
	     * Dispose of the system resources used by this graphics context.
	     * The Graphics context cannot be used after being disposed of.
	     * While the finalization process of the garbage collector will
	     * also dispose of the same system resources, due to the number
	     * of Graphics objects that can be created in short time frames
	     * it is preferable to manually free the associated resources
	     * using this method rather than to rely on a finalization
	     * process which may not happen for a long period of time.
	     * <p>
	     * Graphics objects which are provided as arguments to the paint
	     * and update methods of Components are automatically disposed
	     * by the system when those methods return.  Programmers should,
	     * for efficiency, call the dispose method when finished using
	     * a Graphics object only if it was created directly from a
	     * Component or another Graphics object.
	     *
	     * @see       #create(int, int, int, int)
	     * @see       #finalize()
	     * @see       Component#getGraphics()
	     * @see       Component#paint(Graphics)
	     * @see       Component#update(Graphics)
	     * @since     1.0
	     */
	    public abstract void dispose();

	    /**
	     * Disposes of this graphics context once it is no longer 
	     * referenced.
	     *
	     * @see       #dispose()
	     * @since     1.0
	     */
	    public void finalize() {
	        dispose();
	    }
	}


}
