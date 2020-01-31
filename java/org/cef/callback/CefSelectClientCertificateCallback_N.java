// Copyright (c) 2014 The Chromium Embedded Framework Authors. All rights
// reserved. Use of this source code is governed by a BSD-style license that
// can be found in the LICENSE file.

package org.cef.callback;

import org.cef.security.CefX509Certificate;

class CefSelectClientCertificateCallback_N extends CefNativeAdapter implements CefSelectClientCertificateCallback {
    CefSelectClientCertificateCallback_N() {}

    @Override
    protected void finalize() throws Throwable {
    	cancel();
        super.finalize();
    }

    @Override
    public void Select(CefX509Certificate selectedcertif) {
        try {
        System.out.println("CefSelectClientCertificateCallback_N");
            N_Select(getNativeRef(null),selectedcertif);
        } catch (UnsatisfiedLinkError ule) {
            ule.printStackTrace();
        }
    }

    @Override
    public void cancel() {
        try {
            N_Cancel(getNativeRef(null));
        } catch (UnsatisfiedLinkError ule) {
            ule.printStackTrace();
        }
    }

    
    
    private final native void N_Select(long self,CefX509Certificate selectedcertif);
    private final native void N_Cancel(long self);
    
}
