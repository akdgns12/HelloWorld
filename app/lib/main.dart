import 'dart:io';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:app/screens/splash_screen/splash_screen.dart';
import 'package:app/screens/before_login_screen/before_login_screen.dart';
import 'package:app/screens/login_screen/login_screen.dart';
import 'package:app/screens/home_screen/home_screen.dart';
import 'package:app/screens/mypage_screen/mypage_screen.dart';
import 'package:app/screens/join_screen/register_user_screen.dart';
import 'package:app/screens/join_screen/register_character_screen.dart';
import 'package:app/screens/find_pw_screen/find_pw_screen.dart';
import 'package:app/screens/notice_screen/notice_screen.dart';
import 'package:app/screens/community_screen/community_screen.dart';

void main() async {
  // 앱 처음 실행 시 flutter 엔진 초기화 메소드 호출
  // flutter 자체의 렌더링 엔진을 사용할 때 필요한 기본적인 설정들을 수행하는 메소드라고 생각하면 됨
  WidgetsFlutterBinding.ensureInitialized();
  // await Firebase.initializeApp(
  //   options: DefaultFirebaseOptions.currentPlatform,
  // );
  // await dotenv.load(fileName: '.env');

  // 세로 방향으로 고정
  // SystemChrome.setPreferredOrientations([
  //   DeviceOrientation.portraitUp,
  //   DeviceOrientation.portraitDown,
  // ]);


  runApp(
    MaterialApp(
      title: 'cilent',
      theme: ThemeData(
        fontFamily: 'Pretendard',
        primaryColor: const Color(0xFF499DC6),
        primaryColorLight: const Color(0xFF82ACC1),
        disabledColor: const Color(0xFFD24646).withOpacity(0.78),
        shadowColor: const Color(0xFFA8A8A8),
        secondaryHeaderColor: const Color(0xFF6A6A6A),
      ),
      themeMode: ThemeMode.system,
      initialRoute: '/',
      routes: {
        '/': (context) => const SplashScreen(),
        '/before-login': (context) => const BeforeLogin(),
        '/login': (context) => const Login(),
        '/home': (context) => const Home(),
        '/my-page': (context) => const MyPage(),
        '/register-user': (context) => const RegisterUser(),
        '/register-character': (context) => const RegisterCharacter(),
        '/find-pw': (context) => const FindPassword(),
        '/notice': (context) => const Notice(),
        '/community': (context) => const Community(),
        // '/register': (context) => const CarRegister(),
        // '/detail': (context) => const CarDetail(),
        // '/my-page': (context) => const MyPage(),
        // '/station': (context) => const NaverMapTest(),
        // '/login': (context) => const Login(),
        // '/before-recording': (context) => const BeforeRecordingScreen(),
        // '/recording': (context) => const VideoRecordingScreen(),
        // '/calendar': (context) => const Calendar(),
        // '/error': (context) => const ErrorScreen(),
      },
    ),
  );
}
