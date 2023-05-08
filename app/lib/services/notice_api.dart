import 'package:app/services/api.dart';
import 'package:flutter_secure_storage/flutter_secure_storage.dart';

final storage = FlutterSecureStorage();

// 알림 조회
void getNotice({
  required dynamic Function(dynamic) success,
  required Function(String error) fail,
  Map<String, String>? body,
}) async{
  Future<String?> futureString = storage.read(key: "userSeq");
  String? userSeq = await futureString;
  apiNoticeInstance(
    path: '/$userSeq',
    method: Method.get,
    body: body,
    success: success,
    fail: fail,
  );
}


// 알림 수정
void putNotice({
  required dynamic Function(dynamic) success,
  required Function(String error) fail,
  Map<String, String>? body,
}) async{
  apiNoticeInstance(
    path: '/',
    method: Method.put,
    body: body,
    success: success,
    fail: fail,
  );
}