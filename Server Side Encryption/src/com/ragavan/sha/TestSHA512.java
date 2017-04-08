package com.ragavan.sha;

public class TestSHA512 {
public static void main(String[] args) {
	SHA512 sha512=new SHA512();
	String s=sha512.get_SHA_512_SecurePassword("abc", "abc");
	String hash="f3c41e7b63ee869596fc28bad64120612c520f65928ab4d126c72c6998b551b8ff1ceddfed4373e6717554dc89d1eee6f0ab22fd3675e561aba9ae26a3eec53b";
	System.out.println(s);
	System.out.println(hash);
	System.out.println(s.equals(hash));
}

}
