package org.ecom.cart.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Utility class with some common functions.
 * 
 * @author neel
 *
 */
public final class CommonUtils {

	/**
	 * Avoid to instantiate utility class.
	 */
	private CommonUtils(){
	}
	
	
	/**
	 * Round the value passed to the precision scale passed.
	 * 
	 * @param value
	 * @param scale
	 * @return
	 */
	public static Double round(Double value, int scale) {
	    if (scale < 0) {
	    	throw new IllegalArgumentException("scale is lower than 0");
	    }

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(scale, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	/**
	 * Call {@link #round(Double, int)} with the scale of {@link #ROUNDING_SCALE}.
	 * 
	 * @param value
	 * @return
	 */
	public static Double round(Double value) {
		return round(value, CartConstants.ROUNDING_SCALE);
	}
	
	/**
	 * Rounds the number to the nearest 0.05.
	 * 
	 * It implies a call to {@link #round(Double, int)} with scale 2.
	 * 
	 * @param value
	 * @return
	 */
	public static Double nearestDecimalFive(Double value) {
		return Math.round( round(value) * 20d) / 20d;
	}
	
}
