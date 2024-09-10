**************
Java15 Forum
**************
1- Register Ol
2- Giriş Yap

Database adı: Java15ForumDB
Tablo adı: User
1. entity package içinde User(id,ad,soyad,username,password) adında bir class açalım.
2. register işlemi sırasında username'in daha önce alınmadığı daha önce alınıp alınmadığı kontrol edilmeli.
3. Adınızı giriniz:
4. Soyadınızı giriniz:
5. Username giriniz:
6. Password giriniz:
7. UserRepository hazırlamalısınız. Temek crud işlemleri olmalı. Extra olarak:
   - existsByUserName(String username)
   - Optional<User> doLogin(String username,String password)
Giriş Yap:
   - username giriniz:
   - password giriniz:
   - Eger giriş bilgileri doğru ise o zaman başka bir ekrana geçiş yapılır.

********************
Hosgeldin, Ad Soyad
********************