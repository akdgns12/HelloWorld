import 'dart:async';
import 'dart:convert';
import 'dart:io';
import 'package:http/http.dart' as http;
import 'package:flutter_secure_storage/flutter_secure_storage.dart';
import 'package:flutter_client_sse/flutter_client_sse.dart';


final storage = FlutterSecureStorage();

enum Method { get, post, put, delete, patch }

// apiInstance 생성
Future<dynamic> apiInstance({
  // parameter로 path, method, success 콜백함수, fail 콜백함수, body 수신
  required String path,
  required Method method,
  required dynamic Function(dynamic) success,
  required Function(String error) fail,
  Map<String, dynamic>? body,
  List<Map<String, dynamic>>? bodyList,
}) async {
  // api URL 주소 작성
  String URL = 'https://k8a308.p.ssafy.io/api$path';
  // uri 형식으로 변경
  final url = Uri.parse(URL);
  // Future<String?> futureString = storage.read(key: "accessToken");
  // String? accessToken = await futureString;

  // bodyList가 null이 아니라면 body 대신 사용
  final requestBody =
      bodyList != null ? json.encode(bodyList) : json.encode(body);

  // 기본 headers
  Map<String, String> headers = {
    "Content-Type": "application/json;charset=utf-8",
    // 'Authorization': 'Bearer $accessToken',
  };

  // response 값
  late http.Response response;

  // method에 따라 다르게 요청하고 response값을 수신
  switch (method) {
    case Method.get:
      try {
        response = await http.get(url, headers: headers);
      } catch (error) {
        fail('HTTP 요청 처리 중 오류 발생: $error');
      }
      break;
    case Method.post:
      try {
        response = await http.post(url, headers: headers, body: requestBody);
      } catch (error) {
        fail('HTTP 요청 처리 중 오류 발생: $error');
      }
      break;
    case Method.put:
      try {
        response =
            await http.put(url, headers: headers, body: json.encode(body));
      } catch (error) {
        fail('HTTP 요청 처리 중 오류 발생: $error');
      }
      break;
    case Method.delete:
      try {
        response =
            await http.delete(url, headers: headers, body: json.encode(body));
      } catch (error) {
        fail('HTTP 요청 처리 중 오류 발생: $error');
      }
      break;
    case Method.patch:
      try {
        response =
            await http.patch(url, headers: headers, body: json.encode(body));
      } catch (error) {
        fail('HTTP 요청 처리 중 오류 발생: $error');
      }
      break;
  }

  if (200 <= response.statusCode && response.statusCode < 300) {
    // statuse가 200대이면 성공으로 해서 jsonResponse를 쓰는 콜백함수로 전달
    late dynamic jsonResponse;
    if (response.body.isNotEmpty) {
      jsonResponse = await jsonDecode(utf8.decode(response.bodyBytes));
    } else {
      jsonResponse = {};
    }
    return success(jsonResponse);
  } else {
    // 200대가 아니면 에러 코드를 전달
    fail('${response.statusCode} 에러');
  }
}

// apiInstance 생성
Future<dynamic> apiWithHeaderInstance({
  // parameter로 path, method, success 콜백함수, fail 콜백함수, body 수신
  required String path,
  required Method method,
  required dynamic Function(dynamic) success,
  required Function(String error) fail,
  Map<String, dynamic>? body,
  List<Map<String, dynamic>>? bodyList,
}) async {
  // api URL 주소 작성
  String URL = 'https://k8a308.p.ssafy.io/api$path';
  // uri 형식으로 변경
  final url = Uri.parse(URL);
  Future<String?> futureString = storage.read(key: "accessToken");
  String? accessToken = await futureString;

  // bodyList가 null이 아니라면 body 대신 사용
  final requestBody =
      bodyList != null ? json.encode(bodyList) : json.encode(body);

  // 기본 headers
  Map<String, String> headers = {
    "Content-Type": "application/json;charset=utf-8",
    "Authorization": 'Bearer $accessToken',
  };

  // response 값
  late http.Response response;

  // method에 따라 다르게 요청하고 response값을 수신
  switch (method) {
    case Method.get:
      try {
        response = await http.get(url, headers: headers);
      } catch (error) {
        fail('HTTP 요청 처리 중 오류 발생: $error');
      }
      break;
    case Method.post:
      try {
        response = await http.post(url, headers: headers, body: requestBody);
      } catch (error) {
        fail('HTTP 요청 처리 중 오류 발생: $error');
      }
      break;
    case Method.put:
      try {
        response =
            await http.put(url, headers: headers, body: json.encode(body));
      } catch (error) {
        fail('HTTP 요청 처리 중 오류 발생: $error');
      }
      break;
    case Method.delete:
      try {
        response =
            await http.delete(url, headers: headers, body: json.encode(body));
      } catch (error) {
        fail('HTTP 요청 처리 중 오류 발생: $error');
      }
      break;
    case Method.patch:
      try {
        response =
            await http.patch(url, headers: headers, body: json.encode(body));
      } catch (error) {
        fail('HTTP 요청 처리 중 오류 발생: $error');
      }
      break;
  }

  if (200 <= response.statusCode && response.statusCode < 300) {
    // statuse가 200대이면 성공으로 해서 jsonResponse를 쓰는 콜백함수로 전달
    late dynamic jsonResponse;
    if (response.body.isNotEmpty) {
      jsonResponse = await jsonDecode(utf8.decode(response.bodyBytes));
    } else {
      jsonResponse = {};
    }
    return success(jsonResponse);
  } else {
    // 200대가 아니면 에러 코드를 전달
    fail('${response.statusCode} 에러');
  }
}

// apiInstance 생성
Future<dynamic> apiNoticeInstance({
  // parameter로 path, method, success 콜백함수, fail 콜백함수, body 수신
  required String path,
  required Method method,
  required dynamic Function(dynamic) success,
  required Function(String error) fail,
  Map<String, dynamic>? body,
  List<Map<String, dynamic>>? bodyList,
}) async {
  // api URL 주소 작성
  String URL = 'https://k8a308.p.ssafy.io/notify$path';
  // uri 형식으로 변경
  final url = Uri.parse(URL);
  Future<String?> futureString = storage.read(key: "accessToken");
  String? accessToken = await futureString;
  // bodyList가 null이 아니라면 body 대신 사용
  final requestBody =
      bodyList != null ? json.encode(bodyList) : json.encode(body);

  // 기본 headers
  Map<String, String> headers = {
    "Content-Type": "application/json;charset=utf-8",
    "Cache-Control": "no-cache",
    "Connection": "keep-alive",
    "Authorization": 'Bearer $accessToken',
  };

  // response 값
  late http.Response response;
  dynamic notice;
  final streamController = StreamController<dynamic>();
  // method에 따라 다르게 요청하고 response값을 수신
  switch (method) {
    case Method.get:
      try {
        var a = SSEClient.subscribeToSSE(
            url: url.toString(),
            header: {
              "Authorization": 'Bearer $accessToken',
              "Connection": "keep-alive",
              "Accept": "text/event-stream",
              "Cache-Control": "no-cache",
            });
        // a.listen((event) { print(event.data); notice = event.data!; });
        // print("notice !!! $notice");
        return success(a);
      }
      catch (error) {
        fail('HTTP 요청 처리 중 오류 발생 : $error');
      }

      // try {
      //   response = await http.get(url, headers: headers);
      // } catch (error) {
      //   fail('HTTP 요청 처리 중 오류 발생: $error');
      // }
      break;
    case Method.post:
      try {
        response = await http.post(url, headers: headers, body: requestBody);
      } catch (error) {
        fail('HTTP 요청 처리 중 오류 발생: $error');
      }
      break;
    case Method.put:
      try {
        response =
            await http.put(url, headers: headers, body: json.encode(body));
      } catch (error) {
        fail('HTTP 요청 처리 중 오류 발생: $error');
      }
      break;
    case Method.delete:
      try {
        response =
            await http.delete(url, headers: headers, body: json.encode(body));
      } catch (error) {
        fail('HTTP 요청 처리 중 오류 발생: $error');
      }
      break;
    case Method.patch:
      try {
        response =
            await http.patch(url, headers: headers, body: json.encode(body));
      } catch (error) {
        fail('HTTP 요청 처리 중 오류 발생: $error');
      }
      break;
  }

  if (200 <= response.statusCode && response.statusCode < 300) {
    // statuse가 200대이면 성공으로 해서 jsonResponse를 쓰는 콜백함수로 전달
    late dynamic jsonResponse;
    if (response.body.isNotEmpty) {
      jsonResponse = await jsonDecode(utf8.decode(response.bodyBytes));
    } else {
      jsonResponse = {};
    }
    return success(jsonResponse);
  } else {
    // 200대가 아니면 에러 코드를 전달
    fail('${response.statusCode} 에러');
  }
}
