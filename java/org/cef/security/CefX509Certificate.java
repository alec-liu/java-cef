package org.cef.security;

import javax.security.cert.X509Certificate;

import org.cef.callback.CefNativeAdapter;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;

import javax.security.cert.CertificateException;

public abstract class CefX509Certificate {

	public abstract void addDEREncodedCertificateToTheChain(final byte[] buffer) ;

	public abstract X509Certificate getSubjectCertificate() ;

	public abstract X509Certificate[] getIssuerCertificates() ;

	
	public abstract void release();


	public abstract String toString() ;
	
	

}
