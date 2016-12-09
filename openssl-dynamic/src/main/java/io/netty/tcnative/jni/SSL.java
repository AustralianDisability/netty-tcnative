/*
 * Copyright 2016 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package io.netty.tcnative.jni;

public final class SSL {

    private SSL() { }

    /*
     * Type definitions mostly from mod_ssl
     */
    public static final int UNSET            = -1;

    /*
     * Define the SSL Protocol options
     */
    public static final int SSL_PROTOCOL_NONE  = 0;
    public static final int SSL_PROTOCOL_SSLV2 = (1<<0);
    public static final int SSL_PROTOCOL_SSLV3 = (1<<1);
    public static final int SSL_PROTOCOL_TLSV1 = (1<<2);
    public static final int SSL_PROTOCOL_TLSV1_1 = (1<<3);
    public static final int SSL_PROTOCOL_TLSV1_2 = (1<<4);
    /** TLS_*method according to https://www.openssl.org/docs/manmaster/ssl/SSL_CTX_new.html */
    public static final int SSL_PROTOCOL_TLS   = (SSL_PROTOCOL_SSLV3 | SSL_PROTOCOL_TLSV1 | SSL_PROTOCOL_TLSV1_1 | SSL_PROTOCOL_TLSV1_2);
    public static final int SSL_PROTOCOL_ALL   = (SSL_PROTOCOL_SSLV2 | SSL_PROTOCOL_TLS);

    /*
     * Define the SSL verify levels
     */
    public static final int SSL_CVERIFY_UNSET          = UNSET;
    public static final int SSL_CVERIFY_NONE           = 0;
    public static final int SSL_CVERIFY_OPTIONAL       = 1;
    public static final int SSL_CVERIFY_REQUIRE        = 2;
    public static final int SSL_CVERIFY_OPTIONAL_NO_CA = 3;

    /* Use either SSL_VERIFY_NONE or SSL_VERIFY_PEER, the last 2 options
     * are 'ored' with SSL_VERIFY_PEER if they are desired
     */
    public static final int SSL_VERIFY_NONE                 = 0;
    public static final int SSL_VERIFY_PEER                 = 1;
    public static final int SSL_VERIFY_FAIL_IF_NO_PEER_CERT = 2;
    public static final int SSL_VERIFY_CLIENT_ONCE          = 4;
    public static final int SSL_VERIFY_PEER_STRICT          = (SSL_VERIFY_PEER|SSL_VERIFY_FAIL_IF_NO_PEER_CERT);

    public static final int SSL_OP_MICROSOFT_SESS_ID_BUG            = 0x00000001;
    public static final int SSL_OP_NETSCAPE_CHALLENGE_BUG           = 0x00000002;
    public static final int SSL_OP_NETSCAPE_REUSE_CIPHER_CHANGE_BUG = 0x00000008;
    public static final int SSL_OP_SSLREF2_REUSE_CERT_TYPE_BUG      = 0x00000010;
    public static final int SSL_OP_MICROSOFT_BIG_SSLV3_BUFFER       = 0x00000020;
    public static final int SSL_OP_MSIE_SSLV2_RSA_PADDING           = 0x00000040;
    public static final int SSL_OP_SSLEAY_080_CLIENT_DH_BUG         = 0x00000080;
    public static final int SSL_OP_TLS_D5_BUG                       = 0x00000100;
    public static final int SSL_OP_TLS_BLOCK_PADDING_BUG            = 0x00000200;

    /* Disable SSL 3.0/TLS 1.0 CBC vulnerability workaround that was added
     * in OpenSSL 0.9.6d.  Usually (depending on the application protocol)
     * the workaround is not needed.  Unfortunately some broken SSL/TLS
     * implementations cannot handle it at all, which is why we include
     * it in SSL_OP_ALL. */
    public static final int SSL_OP_DONT_INSERT_EMPTY_FRAGMENTS      = 0x00000800;

    /* SSL_OP_ALL: various bug workarounds that should be rather harmless.
     *             This used to be 0x000FFFFFL before 0.9.7. */
    public static final int SSL_OP_ALL                              = 0x00000FFF;
    /* As server, disallow session resumption on renegotiation */
    public static final int SSL_OP_NO_SESSION_RESUMPTION_ON_RENEGOTIATION = 0x00010000;
    /* Don't use compression even if supported */
    public static final int SSL_OP_NO_COMPRESSION                         = 0x00020000;
    /* Permit unsafe legacy renegotiation */
    public static final int SSL_OP_ALLOW_UNSAFE_LEGACY_RENEGOTIATION      = 0x00040000;
    /* If set, always create a new key when using tmp_eddh parameters */
    public static final int SSL_OP_SINGLE_ECDH_USE                  = 0x00080000;
    /* If set, always create a new key when using tmp_dh parameters */
    public static final int SSL_OP_SINGLE_DH_USE                    = 0x00100000;
    /* Set on servers to choose the cipher according to the server's
     * preferences */
    public static final int SSL_OP_CIPHER_SERVER_PREFERENCE         = 0x00400000;
    /* If set, a server will allow a client to issue a SSLv3.0 version number
     * as latest version supported in the premaster secret, even when TLSv1.0
     * (version 3.1) was announced in the client hello. Normally this is
     * forbidden to prevent version rollback attacks. */
    public static final int SSL_OP_TLS_ROLLBACK_BUG                 = 0x00800000;

    public static final int SSL_OP_NO_SSLv2                         = 0x01000000;
    public static final int SSL_OP_NO_SSLv3                         = 0x02000000;
    public static final int SSL_OP_NO_TLSv1                         = 0x04000000;
    public static final int SSL_OP_NO_TLSv1_2                       = 0x08000000;
    public static final int SSL_OP_NO_TLSv1_1                       = 0x10000000;

    public static final int SSL_OP_NO_TICKET                        = 0x00004000;

    // SSL_OP_PKCS1_CHECK_1 and SSL_OP_PKCS1_CHECK_2 flags are unsupported
    // in the current version of OpenSSL library. See ssl.h changes in commit
    // 7409d7ad517650db332ae528915a570e4e0ab88b (30 Apr 2011) of OpenSSL.
    /**
     * @deprecated Unsupported in the current version of OpenSSL
     */
    @Deprecated
    public static final int SSL_OP_PKCS1_CHECK_1                    = 0x08000000;
    /**
     * @deprecated Unsupported in the current version of OpenSSL
     */
    @Deprecated
    public static final int SSL_OP_PKCS1_CHECK_2                    = 0x10000000;
    public static final int SSL_OP_NETSCAPE_CA_DN_BUG               = 0x20000000;
    public static final int SSL_OP_NETSCAPE_DEMO_CIPHER_CHANGE_BUG  = 0x40000000;

    public static final int SSL_MODE_CLIENT         = 0;
    public static final int SSL_MODE_SERVER         = 1;
    public static final int SSL_MODE_COMBINED       = 2;

    /* Only support OFF and SERVER for now */
    public static final long SSL_SESS_CACHE_OFF = 0x0000;
    public static final long SSL_SESS_CACHE_SERVER = 0x0002;

    public static final int SSL_SELECTOR_FAILURE_NO_ADVERTISE = 0;
    public static final int SSL_SELECTOR_FAILURE_CHOOSE_MY_LAST_PROTOCOL = 1;

    public static final int SSL_ST_CONNECT = 0x1000;
    public static final int SSL_ST_ACCEPT =  0x2000;

    public static final int SSL_MODE_ENABLE_PARTIAL_WRITE           = 0x00000001;
    public static final int SSL_MODE_ACCEPT_MOVING_WRITE_BUFFER     = 0x00000002;
    public static final int SSL_MODE_AUTO_RETRY                     = 0x00000004;
    public static final int SSL_MODE_NO_AUTO_CHAIN                  = 0x00000008;
    public static final int SSL_MODE_RELEASE_BUFFERS                = 0x00000010;
    public static final int SSL_MODE_SEND_CLIENTHELLO_TIME          = 0x00000020;
    public static final int SSL_MODE_SEND_SERVERHELLO_TIME          = 0x00000040;
    public static final int SSL_MODE_SEND_FALLBACK_SCSV             = 0x00000080;

    /* Return OpenSSL version number */
    public static native int version();

    /* Return OpenSSL version string */
    public static native String versionString();

    /**
     * Initialize OpenSSL support.
     *
     * This function needs to be called once for the
     * lifetime of JVM. See {@link Library#initialize(String, String)}
     *
     * @param engine Support for external a Crypto Device ("engine"),
     *                usually a hardware accelerator card for crypto operations.
     * @return APR status code
     */
    static native int initialize(String engine);

    /**
     * Initialize new in-memory BIO that is located in the secure heap.
     * @return New BIO handle
     */
    public static native long newMemBIO() throws Exception;

    /**
     * Return last SSL error string
     */
    public static native String getLastError();

    /**
     * Return true if all the requested SSL_OP_* are supported by OpenSSL.
     *
     * <i>Note that for versions of tcnative &lt; 1.1.25, this method will
     * return <code>true</code> if and only if <code>op</code>=
     * {@link #SSL_OP_ALLOW_UNSAFE_LEGACY_RENEGOTIATION} and tcnative
     * supports that flag.</i>
     *
     * @param op Bitwise-OR of all SSL_OP_* to test.
     *
     * @return true if all SSL_OP_* are supported by OpenSSL library.
     */
    public static native boolean hasOp(int op);

    /*
     * Begin Twitter API additions
     */

    public static final int SSL_SENT_SHUTDOWN = 1;
    public static final int SSL_RECEIVED_SHUTDOWN = 2;

    public static final int SSL_ERROR_NONE             = 0;
    public static final int SSL_ERROR_SSL              = 1;
    public static final int SSL_ERROR_WANT_READ        = 2;
    public static final int SSL_ERROR_WANT_WRITE       = 3;
    public static final int SSL_ERROR_WANT_X509_LOOKUP = 4;
    public static final int SSL_ERROR_SYSCALL          = 5; /* look at error stack/return value/errno */
    public static final int SSL_ERROR_ZERO_RETURN      = 6;
    public static final int SSL_ERROR_WANT_CONNECT     = 7;
    public static final int SSL_ERROR_WANT_ACCEPT      = 8;

    /**
     * SSL_new
     * @param ctx Server or Client context to use.
     * @param server if true configure SSL instance to use accept handshake routines
     *               if false configure SSL instance to use connect handshake routines
     * @return pointer to SSL instance (SSL *)
     */
    public static native long newSSL(long ctx, boolean server);

    /**
     * SSL_get_error
     * @param ssl SSL pointer (SSL *)
     * @param ret TLS/SSL I/O return value
     */
    public static native int getError(long ssl, int ret);

    /**
     * BIO_ctrl_pending
     * @param bio BIO pointer (BIO *)
     * @return
     */
    public static native int pendingWrittenBytesInBIO(long bio);

    /**
     * SSL_pending
     * @param ssl SSL pointer (SSL *)
     * @return
     */
    public static native int pendingReadableBytesInSSL(long ssl);

    /**
     * BIO_write
     * @param bio
     * @param wbuf
     * @param wlen
     * @return
     */
    public static native int writeToBIO(long bio, long wbuf, int wlen);

    /**
     * BIO_read
     * @param bio
     * @param rbuf
     * @param rlen
     * @return
     */
    public static native int readFromBIO(long bio, long rbuf, int rlen);

    /**
     * BIO_should_retry
     * @param bio the BIO.
     * @return {@code true} if the failed BIO operation should be retried later.
     */
    public static native boolean shouldRetryBIO(long bio);

    /**
     * SSL_write
     * @param ssl the SSL instance (SSL *)
     * @param wbuf
     * @param wlen
     * @return
     */
    public static native int writeToSSL(long ssl, long wbuf, int wlen);

    /**
     * SSL_read
     * @param ssl the SSL instance (SSL *)
     * @param rbuf
     * @param rlen
     * @return
     */
    public static native int readFromSSL(long ssl, long rbuf, int rlen);

    /**
     * SSL_get_shutdown
     * @param ssl the SSL instance (SSL *)
     * @return
     */
    public static native int getShutdown(long ssl);

    /**
     * SSL_set_shutdown
     * @param ssl the SSL instance (SSL *)
     * @param mode
     */
    public static native void setShutdown(long ssl, int mode);

    /**
     * SSL_free
     * @param ssl the SSL instance (SSL *)
     */
    public static native void freeSSL(long ssl);

    /**
     * Creates a BIO with the default max BIO size.
     *
     * @see #makeNetworkBIO(long, int)
     */
    public static long makeNetworkBIO(long ssl) {
        return makeNetworkBIO(ssl, 0);
    }

    /**
     * Creates a BIO with the given max BIO size.
     *
     * @see #makeNetworkBIO(long, int, int)
     */
    public static long makeNetworkBIO(long ssl, int maxBioSize) {
        return makeNetworkBIO0(ssl, maxBioSize, maxBioSize);
    }

    /**
     * Wire up internal and network BIOs for the given SSL instance.
     *
     * <b>Warning: you must explicitly free this resource by calling freeBIO</b>
     *
     * While the SSL's internal/application data BIO will be freed when freeSSL is called on
     * the provided SSL instance, you must call freeBIO on the returned network BIO.
     *
     * Please see <a href="https://www.openssl.org/docs/man1.0.1/crypto/BIO_s_bio.html">man BIO_s_bio (example section)</a>
     * for more details.
     *
     * @param ssl the SSL instance (SSL *)
     * @param maxInternalBIOSize The maximum size of the application side BIO. Pass 0 to use the default max size.
     * @param maxNetworkBIOSize The maximum size of the network side BIO. Pass 0 to use the default max size.
     * @return pointer to the Network BIO (BIO *)
     */
    public static long makeNetworkBIO(long ssl, int maxInternalBIOSize, int maxNetworkBIOSize) {
        return makeNetworkBIO0(ssl, maxInternalBIOSize, maxNetworkBIOSize);
    }

    private static native long makeNetworkBIO0(long ssl, int maxInternalBIOSize, int maxNetworkBIOSize);

    /**
     * BIO_free
     * @param bio
     */
    public static native void freeBIO(long bio);

    /**
     * SSL_shutdown
     * @param ssl the SSL instance (SSL *)
     * @return
     */
    public static native int shutdownSSL(long ssl);

    /**
     * Get the error number representing the last error OpenSSL encountered on this thread.
     * @return
     */
    public static native int getLastErrorNumber();

    /**
     * SSL_get_cipher
     * @param ssl the SSL instance (SSL *)
     * @return
     */
    public static native String getCipherForSSL(long ssl);

    /**
     * SSL_get_version
     * @param ssl the SSL instance (SSL *)
     * @return
     */
    public static native String getVersion(long ssl);

    /**
     * SSL_do_handshake
     * @param ssl the SSL instance (SSL *)
     */
    public static native int doHandshake(long ssl);

    /**
     * SSL_in_init
     * @param SSL
     * @return
     */
    public static native int isInInit(long SSL);

    /**
     * SSL_get0_next_proto_negotiated
     * @param ssl the SSL instance (SSL *)
     * @return
     */
    public static native String getNextProtoNegotiated(long ssl);

    /*
     * End Twitter API Additions
     */

    /**
     * SSL_get0_alpn_selected
     * @param ssl the SSL instance (SSL *)
     * @return
     */
    public static native String getAlpnSelected(long ssl);

    /**
     * Get the peer certificate chain or {@code null} if non was send.
     */
    public static native byte[][] getPeerCertChain(long ssl);

    /**
     * Get the peer certificate or {@code null} if non was send.
     */
    public static native byte[] getPeerCertificate(long ssl);
    /*
     * Get the error number representing for the given {@code errorNumber}.
     */
    public static native String getErrorString(long errorNumber);

    /**
     * SSL_get_time
     * @param ssl the SSL instance (SSL *)
     * @return returns the time at which the session ssl was established. The time is given in seconds since the Epoch
     */
    public static native long getTime(long ssl);

    /**
     * SSL_get_timeout
     * @param ssl the SSL instance (SSL *)
     * @return returns the timeout for the session ssl The time is given in seconds since the Epoch
     */
    public static native long getTimeout(long ssl);

    /**
     * SSL_set_timeout
     * @param ssl the SSL instance (SSL *)
     * @param seconds timeout in seconds
     * @return returns the timeout for the session ssl before this call. The time is given in seconds since the Epoch
     */
    public static native long setTimeout(long ssl, long seconds);

    /**
     * Set Type of Client Certificate verification and Maximum depth of CA Certificates
     * in Client Certificate verification.
     * <br />
     * This directive sets the Certificate verification level for the Client
     * Authentication. Notice that this directive can be used both in per-server
     * and per-directory context. In per-server context it applies to the client
     * authentication process used in the standard SSL handshake when a connection
     * is established. In per-directory context it forces a SSL renegotiation with
     * the reconfigured client verification level after the HTTP request was read
     * but before the HTTP response is sent.
     * <br />
     * The following levels are available for level:
     * <pre>
     * SSL_CVERIFY_NONE           - No client Certificate is required at all
     * SSL_CVERIFY_OPTIONAL       - The client may present a valid Certificate
     * SSL_CVERIFY_REQUIRE        - The client has to present a valid Certificate
     * SSL_CVERIFY_OPTIONAL_NO_CA - The client may present a valid Certificate
     *                              but it need not to be (successfully) verifiable
     * </pre>
     * <br />
     * The depth actually is the maximum number of intermediate certificate issuers,
     * i.e. the number of CA certificates which are max allowed to be followed while
     * verifying the client certificate. A depth of 0 means that self-signed client
     * certificates are accepted only, the default depth of 1 means the client
     * certificate can be self-signed or has to be signed by a CA which is directly
     * known to the server (i.e. the CA's certificate is under
     * {@code setCACertificatePath}, etc.
     *
     * @param ssl the SSL instance (SSL *)
     * @param level Type of Client Certificate verification.
     * @param depth Maximum depth of CA Certificates in Client Certificate
     *              verification.
     */
    public static native void setVerify(long ssl, int level, int depth);

    /**
     * Set OpenSSL Option.
     * @param ssl the SSL instance (SSL *)
     * @param options  See SSL.SSL_OP_* for option flags.
     */
    public static native void setOptions(long ssl, int options);

    /**
     * Clear OpenSSL Option.
     * @param ssl the SSL instance (SSL *)
     * @param options  See SSL.SSL_OP_* for option flags.
     */
    public static native void clearOptions(long ssl, int options);

    /**
     * Get OpenSSL Option.
     * @param ssl the SSL instance (SSL *)
     * @return options  See SSL.SSL_OP_* for option flags.
     */
    public static native int getOptions(long ssl);

    /**
     * Returns all Returns the cipher suites that are available for negotiation in an SSL handshake.
     * @param ssl the SSL instance (SSL *)
     * @return ciphers
     */
    public static native String[] getCiphers(long ssl);

    /**
     * Returns the cipher suites available for negotiation in SSL handshake.
     * <br />
     * This complex directive uses a colon-separated cipher-spec string consisting
     * of OpenSSL cipher specifications to configure the Cipher Suite the client
     * is permitted to negotiate in the SSL handshake phase. Notice that this
     * directive can be used both in per-server and per-directory context.
     * In per-server context it applies to the standard SSL handshake when a
     * connection is established. In per-directory context it forces a SSL
     * renegotiation with the reconfigured Cipher Suite after the HTTP request
     * was read but before the HTTP response is sent.
     * @param ssl the SSL instance (SSL *)
     * @param ciphers an SSL cipher specification
     */
    public static native boolean setCipherSuites(long ssl, String ciphers)
            throws Exception;

    /**
     * Returns the ID of the session as byte array representation.
     *
     * @param ssl the SSL instance (SSL *)
     * @return the session as byte array representation obtained via SSL_SESSION_get_id.
     */
    public static native byte[] getSessionId(long ssl);

    /**
     * Returns the number of handshakes done for this SSL instance. This also includes renegations.
     *
     * @param ssl the SSL instance (SSL *)
     * @return the number of handshakes done for this SSL instance.
     */
    public static native int getHandshakeCount(long ssl);

    /**
     * Clear all the errors from the error queue that OpenSSL encountered on this thread.
     */
    public static native void clearError();

    /**
     * Call SSL_renegotiate.
     *
     * @param ssl the SSL instance (SSL *)
     * @return the result of the operation
     */
    public static native int renegotiate(long ssl);

    /**
     * Call SSL_set_state.
     *
     * @param ssl the SSL instance (SSL *)
     */
    public static native void setState(long ssl, int state);

    /**
     * Call SSL_set_tlsext_host_name
     *
     * @param ssl the SSL instance (SSL *)
     * @param hostname the hostname
     */
    public static native void setTlsExtHostName(long ssl, String hostname);

    public static native String[] authenticationMethods(long ssl);

    /**
     * Set BIO of PEM-encoded Server CA Certificates
     * <p>
     * This directive sets the optional all-in-one file where you can assemble the
     * certificates of Certification Authorities (CA) which form the certificate
     * chain of the server certificate. This starts with the issuing CA certificate
     * of of the server certificate and can range up to the root CA certificate.
     * Such a file is simply the concatenation of the various PEM-encoded CA
     * Certificate files, usually in certificate chain order.
     * <p>
     * But be careful: Providing the certificate chain works only if you are using
     * a single (either RSA or DSA) based server certificate. If you are using a
     * coupled RSA+DSA certificate pair, this will work only if actually both
     * certificates use the same certificate chain. Otherwsie the browsers will be
     * confused in this situation.
     * @param ssl Server or Client to use.
     * @param bio BIO of PEM-encoded Server CA Certificates.
     * @param skipfirst Skip first certificate if chain file is inside
     *                  certificate file.
     */
    public static native void setCertificateChainBio(long ssl, long bio, boolean skipfirst);

    /**
     * Set Certificate
     * <br>
     * Point setCertificate at a PEM encoded certificate stored in a BIO. If
     * the certificate is encrypted, then you will be prompted for a
     * pass phrase.  Note that a kill -HUP will prompt again. A test
     * certificate can be generated with `make certificate' under
     * built time. Keep in mind that if you've both a RSA and a DSA
     * certificate you can configure both in parallel (to also allow
     * the use of DSA ciphers, etc.)
     * <br>
     * If the key is not combined with the certificate, use key param
     * to point at the key file.  Keep in mind that if
     * you've both a RSA and a DSA private key you can configure
     * both in parallel (to also allow the use of DSA ciphers, etc.)
     * @param ssl Server or Client to use.
     * @param certBio Certificate BIO.
     * @param keyBio Private Key BIO to use if not in cert.
     * @param password Certificate password. If null and certificate
     *                 is encrypted.
     */
    public static native void setCertificateBio(
            long ssl, long certBio, long keyBio, String password) throws Exception;

    /**
     * Parse private key from BIO and return {@code EVP_PKEY} pointer.
     *
     * <p>Be sure you understand how OpenSsl will behave with respect to reference counting!
     *
     * If the {@code EVP_PKEY} pointer is used with the client certificate callback
     * {@link CertificateRequestedCallback} the ownership goes over to OpenSsl / Tcnative and so calling
     * {@link #freePrivateKey(long)} should <strong>NOT</strong> be done in this case. Otherwise you may
     * need to call {@link #freePrivateKey(long)} to decrement the reference count and free memory.
     */
    public static native long parsePrivateKey(long privateKeyBio, String password) throws Exception;

    /**
     * Free private key ({@code EVP_PKEY} pointer).
     */
    public static native void freePrivateKey(long privateKey);

    /**
     * Parse X509 chain from BIO and return ({@code STACK_OF(X509)} pointer).
     *
     * <p>Be sure you understand how OpenSsl will behave with respect to reference counting!
     *
     * If the {@code STACK_OF(X509)} pointer is used with the client certificate callback
     * {@link CertificateRequestedCallback} the ownership goes over to OpenSsl / Tcnative and and so calling
     * {@link #freeX509Chain(long)} should <strong>NOT</strong> be done in this case. Otherwise you may
     * need to call {@link #freeX509Chain(long)} to decrement the reference count and free memory.
     */
    public static native long parseX509Chain(long x509ChainBio) throws Exception;

    /**
     * Free x509 chain ({@code STACK_OF(X509)} pointer).
     */
    public static native void freeX509Chain(long x509Chain);
}