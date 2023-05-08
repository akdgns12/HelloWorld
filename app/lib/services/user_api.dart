import 'package:app/services/api.dart';
import 'package:flutter_secure_storage/flutter_secure_storage.dart';

final storage = FlutterSecureStorage();

// 회원가입
void signUp({
  required dynamic Function(dynamic) success,
  required Function(String error) fail,
  Map<String, String>? body,
}) {
  apiInstance(
    path: '/user/signUp',
    method: Method.post,
    body: body,
    success: success,
    fail: fail,
  );
}

// 로그인
void login({
  required dynamic Function(dynamic) success,
  required Function(String error) fail,
  Map<String, String>? body,
}) {
  apiInstance(
    path: '/user/signIn',
    method: Method.post,
    body: body,
    success: success,
    fail: fail,
  );
}

// 유저정보
void getUserInfo({
  required dynamic Function(dynamic) success,
  required Function(String error) fail,
  Map<String, String>? body,
}) async {
  Future<String?> futureString = storage.read(key: "userSeq");
  String? userSeq = await futureString;
  print(userSeq);
  apiWithHeaderInstance(
    path: '/user/userInfo/$userSeq',
    method: Method.get,
    body: body,
    success: success,
    fail: fail,
  );
}