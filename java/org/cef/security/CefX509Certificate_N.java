package org.cef.security;

import javax.security.cert.X509Certificate;

import org.cef.callback.CefDragData;
import org.cef.callback.CefNative;
import org.cef.callback.CefNativeAdapter;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.security.cert.CertificateException;

public final class CefX509Certificate_N extends CefX509Certificate implements CefNative {

	final ArrayList<X509Certificate> chainofcertificates = new ArrayList<X509Certificate>();

	CefX509Certificate_N() {
		super();
	};

	@Override
	public void addDEREncodedCertificateToTheChain(final byte[] buffer) {
		try {
			
			X509Certificate subjectcertificate = X509Certificate.getInstance(buffer);
			chainofcertificates.add(subjectcertificate);
			
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Override
	public X509Certificate getSubjectCertificate() {
		if (!chainofcertificates.isEmpty()) {
			return chainofcertificates.get(0);
		}
		return null;

	};

	@Override
	public X509Certificate[] getIssuerCertificates() {
		if (chainofcertificates.size() > 1) {
			return chainofcertificates.subList(1, chainofcertificates.size())
					.toArray(new X509Certificate[chainofcertificates.size() - 1]);

		}
		return new X509Certificate[0];

	};

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("\n");
		sb.append("native reference" + this.getNativeRef(""));
		sb.append("\n");
		int loopindex = 0;
		for (X509Certificate certif : chainofcertificates) {
			sb.append("Certificate " + loopindex + "(chain index)----" + "\n");
			sb.append(certif.toString());

			sb.append("-----------------------------" + "\n");
			loopindex++;
		}

		return sb.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		release();
		super.finalize();
	}

	@Override
	public void release() {
		try {
		
			N_Release(getNativeRef(null));
		} catch (UnsatisfiedLinkError ule) {
			ule.printStackTrace();
		}
	}

	private final native void N_Release(long self);

	// Used internally to store a pointer to the CEF object.
	private long N_CefHandle = 0;

	@Override
	public void setNativeRef(String identifer, long nativeRef) {
		N_CefHandle = nativeRef;
	}

	@Override
	public long getNativeRef(String identifer) {
		return N_CefHandle;
	}

}
