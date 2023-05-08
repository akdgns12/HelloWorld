import 'package:app/services/api.dart';
import 'package:flutter_secure_storage/flutter_secure_storage.dart';

final storage = FlutterSecureStorage();

// 게시판 리스트
void getBoardList({
  required dynamic Function(dynamic) success,
  required Function(String error) fail,
  Map<String, String>? body,
}) async{
  // Future<String?> futureString = storage.read(key: "userSeq");
  // String? userSeq = await futureString;
  apiWithHeaderInstance(
    path: '/board/board-list?start=0&size=10',
    method: Method.get,
    body: body,
    success: success,
    fail: fail,
  );
}