import 'package:app/services/api.dart';

// 회원 정보 초기화
void deleteUserInfo({
  required dynamic Function(dynamic) success,
  required Function(String error) fail,
  Map<String, String>? body,
}) {
  apiWithHeaderInstance(
    path: '/user/delete',
    method: Method.delete,
    body: body,
    success: success,
    fail: fail,
  );
}

// 로그아웃
void logout({
  required dynamic Function(dynamic) success,
  required Function(String error) fail,
  Map<String, String>? body,
}) {
  apiWithHeaderInstance(
    path: '/user/logout',
    method: Method.post,
    body: body,
    success: success,
    fail: fail,
  );
}