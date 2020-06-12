package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

 class Solution93 {

	 List<String> result = new ArrayList<>();
	    public List<String> restoreIpAddresses(String s) {
	        int points=3;
	        int i=0;
	        String[] ip = new String[4];
	        restoreIpAddressUtil(s,i,points,ip);
			return result;
	    }
	    
	    void restoreIpAddressUtil(String s, int k, int points,String[] ip){
	        if(k==4) {
	        	result.add(ip[0]+"."+ip[1]+"."+ip[2]+"."+ip[3]);
	            
	        }
	        for(int i=1;i<4;i++){
	        	if(s.length()<i)
	        		break;
	            String chunk = s.substring(0,i);
	            String remaining = s.substring(i,s.length());
	            
	            if(isValid(chunk) && isRemainingValid(remaining, points)){
	                ip[k]=chunk;
	                restoreIpAddressUtil(remaining,k+1,points-1,ip);
	            }
	            else{
	                continue;
	            }
	            
	        }
	        
	    }
	    
	    boolean isValid(String s){
	        if(s.length()>3)
	            return false;
                 
                if(s.lenth()>1 && s.charAt(0)=='0')
                    return false;
	        
	        int ipChunk = Integer.parseInt(s);
	        if(ipChunk<256)
	            return true;
	        else
	            return false;
	    }
	    
	     boolean isRemainingValid(String s,int l){
	        if(s.length()>=l && s.length()<=l*3)
	            return true;
	         else
	             return false;
	    }
}
