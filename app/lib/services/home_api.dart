import 'package:app/services/api.dart';
import 'package:flutter_secure_storage/flutter_secure_storage.dart';

final storage = FlutterSecureStorage();

// 잔디
void getGrass({
  required dynamic Function(dynamic) success,
  required Function(String error) fail,
  Map<String, String>? body,
}) async{
  Future<String?> futureString = storage.read(key: "userSeq");
  String? userSeq = await futureString;
  apiWithHeaderInstance(
    path: '/grass?startDate=2022-01-01&endDate=2023-05-03&userSeq=$userSeq',
    method: Method.get,
    body: body,
    success: success,
    fail: fail,
  );
}