package com.wipro.service;

public final class IntrAmtCalCulatorimple implements IntrAmtCalCulator1 {
public final float calIntrAmt(float principle,float rate,float time){
	System.out.println("Target Class method");
	return (principle*rate*time)/100.0f;
}
}
