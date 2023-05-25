// Copyright (c) 2014 The Chromium Embedded Framework Authors. All rights
// reserved. Use of this source code is governed by a BSD-style license that
// can be found in the LICENSE file.

package org.cef.callback;

import org.cef.security.CefX509Certificate;

/**
 * Callback interface used for asynchronous continuation of authentication
 * requests.
 */
public interface CefSelectClientCertificateCallback {
    /**
     * Continue the authentication request.
     */
    public void select(CefX509Certificate selectedcertif);

    public void cancel();
}
