package org.cef.security;

import javax.security.cert.X509Certificate;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.security.cert.CertificateException;

public final class CefX509Certificate {

	
	private ByteBuffer address2linkedcertificate; //pointer 2 linked  CefRefPtr<CefX509Certificate> cert
	
	
	
	ArrayList<X509Certificate> chainofcertificates = new ArrayList<X509Certificate>();

	public CefX509Certificate() {
	};

	public void addDEREncodedCertificateToTheChain(final byte[] buffer) throws CertificateException {

		System.out.println("addDEREncodedCertificateToTheChain call");
		X509Certificate subjectcertificate = X509Certificate.getInstance(buffer);
		chainofcertificates.add(subjectcertificate);
		System.out.println(subjectcertificate);

	}

	
	public X509Certificate getSubjectCertificate() throws Exception {
		if(!chainofcertificates.isEmpty())
		{
			return chainofcertificates.get(0);
		}
		else
			throw new Exception("CefX509Certificate hasn' been initialized: no certificates");
	};

	public X509Certificate[] getIssuerCertificates() throws Exception {
		if(chainofcertificates.size()>1)
		{
		return	chainofcertificates.subList(1,chainofcertificates.size()).toArray(new X509Certificate[chainofcertificates.size()-1]);
			
			
		}else
		{	
			if(!chainofcertificates.isEmpty())
			throw new Exception("No issuers were present");
			else
			throw new Exception("CefX509Certificate hasn' been initialized: no certificates");
		}
		
		
	};
	
	
	public String toString()
	{
		StringBuilder sb=new StringBuilder();
		
		sb.append("\n");
		int loopindex=0;
		for(X509Certificate certif:chainofcertificates)
		{
			sb.append("Certificate "+loopindex +"(chain index)----"+"\n");
			sb.append(certif.toString());
			
			
			sb.append("-----------------------------"+"\n");
			loopindex++;
		}
		
		return sb.toString();
	}

	
		
}
