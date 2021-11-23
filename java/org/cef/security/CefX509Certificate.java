package org.cef.security;

import java.security.cert.X509Certificate;

public abstract class CefX509Certificate {

	public abstract void addDEREncodedCertificateToTheChain(final byte[] buffer) ;

	public abstract X509Certificate getSubjectCertificate() ;

	public abstract X509Certificate[] getIssuerCertificates() ;

	public abstract void release();

	public abstract String toString() ;

}
