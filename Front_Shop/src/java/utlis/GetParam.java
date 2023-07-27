/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utlis;

import jakarta.servlet.http.HttpServletRequest;

/**
 *
 * @author dinhd513
 */

    public class GetParam {
     /**
     * Get string from request parameter and validate it, if it invalid, return
     * default value
     *
     * @param request servlet request
     * @param field request parameter name
     * @param label Label
     * @param min minimum length
     * @param max maximum length
     * @return Valid string
     */
    public static String getStringParam(HttpServletRequest request, String field, String placeholder,final String REGEX,String errorMatches, int min, int max,
            String defaultValue) {
        String value = (String) request.getParameter(field);
 
        if (value == null || value.trim().isEmpty()) {
            if (defaultValue == null) {
                request.setAttribute(field + "Error", placeholder + " is required");
                return null;
            }

            return defaultValue;
        }
        
        if (!value.matches(REGEX)){
            request.setAttribute(field + "Error", errorMatches);
            return null;
        }
        if (value.trim().length() > max) {
            request.setAttribute(field + "Error", placeholder + " is less than or equal " + max + " character(s)");
            return null;
        }
        if (value.trim().length() < min) {
            request.setAttribute(field + "Error", placeholder + " is greater than or equal " + min + " character(s)");
            return null;
        }
        return value.trim();
    }
    
    

    /**
     * Get integer from request parameter and validate it, if it invalid, return
     * default value
     *
     * @param request servlet request
     * @param field request parameter name
     * @param label Label
     * @param min minimum number
     * @param max maximum number
     * @return Valid integer
     */
    public static Integer getIntParams(HttpServletRequest request, String field, String placeholder, int min, int max,
            Integer defaultValue) {

        String value = (String) request.getParameter(field);
        Integer realValue;

        if (value == null || value.isEmpty()) {
            if (defaultValue == null) {
                request.setAttribute(field + "Error", placeholder + " is required");
                return null;
            }
            return defaultValue;
        }
        try {
        
            realValue = Integer.valueOf(value);
        } catch (NumberFormatException e) {
           
            request.setAttribute(field + "Error",
                    placeholder + " must be a number and less than or equal " + Integer.MAX_VALUE);
            return null;
        }
        if (realValue > max) {
            request.setAttribute(field + "Error", placeholder + " is less than or equal " + max);
            return null;
        }
        if (realValue < min) {
            request.setAttribute(field + "Error", placeholder + " is greater than or equal " + min);
            return null;
        }

        return realValue;
    }

    /**
     * Get float from request parameter and validate it, if it invalid, return
     * default value
     *
     * @param request servlet request
     * @param field request parameter name
     * @param label Label
     * @param min minimum number
     * @param max maximum number
     * @return Valid float
     */
    public static Float getFloatParams(HttpServletRequest request, String field, String placeholder, float min, float max,
            Float defaultValue) {

        String value = (String) request.getParameter(field);
        Float realValue;
        if (value == null || value.isEmpty()) {
            if (defaultValue == null) {
                request.setAttribute(field + "Error", placeholder + " is required");
                return null;
            }
            return defaultValue;
        }

        try {
            realValue = Float.parseFloat(value);
        } catch (NumberFormatException e) {

            request.setAttribute(field + "Error",
                    placeholder + " must be a number and less than or equal " + Float.MAX_VALUE);
            return null;
        }
        if (realValue > max) {
            request.setAttribute(field + "Error", placeholder + " is less than or equal " + max);
            return null;
        }
        if (realValue < min) {
            request.setAttribute(field + "Error", placeholder + " is greater than or equal " + min);
            return null;
        }

        return realValue;
    }


   
    /**
     * Get attribute, if it null, return default value
     *
     * @param request servlet request
     * @param field request parameter name
     * @param defaultValue default value
     * @return valid value
     */
    public static Object getClientAttribute(HttpServletRequest request, String field, Object defaultValue) {
        Object value = request.getAttribute(field);
        if (value == null) {
            return defaultValue;
        }

        return value;
    }

    public static Object getClientParams(HttpServletRequest request, String field, Object defaultValue) {
        Object value = request.getParameter(field);
        if (value == null) {
            return defaultValue;
        }

        return value;
    }
    
    public static String getNumberPhone(HttpServletRequest request, String name, final String REGEX, String defaultValue) {
        String value = (String) request.getParameter(name);
        if (!value.matches(REGEX)){
            return null;
        }
        return value.trim();
    }
    
    
    
}
