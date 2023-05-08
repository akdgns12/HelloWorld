import 'dart:async';
import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:app/widgets/common/footer.dart';
import 'package:app/services/notice_api.dart';
import 'package:flutter_secure_storage/flutter_secure_storage.dart';

class Notice extends StatefulWidget {
  const Notice({Key? key}) : super(key: key);

  @override
  State<Notice> createState() => _NoticeState();
}

class _NoticeState extends State<Notice> {
  var notices = new List.empty(growable: true);
  List<dynamic> temp = [];

  static const storage = FlutterSecureStorage();
  String? accessToken;
  String? userSeq;

  @override
  void initState() {
    setAccessToken().then((value) {
      setState(() {
        accessToken = value;
      });
    });
    setUserSeq().then((value) {
      setState(() {
        userSeq = value;
      });
    });

    // Stream<http.Response> noticeStream() async* {
    //   yield* Stream.periodic(Duration(seconds: 5), (_) {
    //
    //     // return http.get(Uri.parse('https://k8a308.p.ssafy.io/notify/$userSeq'),
    //     //     headers: {
    //     //       "Authorization": 'Bearer $accessToken',
    //     //       "Connection": "keep-alive",
    //     //       "Cache-Control": "no-cache",
    //     //     });
    //     getNotice(success: (dynamic response) {
    //       setState(() {
    //         notices = response;
    //       });
    //     }, fail: (error) {
    //       print(error);
    //     });
    //
    //   });
    //
    // }
    // SSEClient.subscribeToSSE(
    //     url: 'https://k8a308.p.ssafy.io/notify/$userSeq',
    //     header: {
    //       "Authorization": 'Bearer $accessToken',
    //       "Connection": "keep-alive",
    //       "Accept": "text/event-stream",
    //       "Cache-Control": "no-cache",
    //     }).listen((event) async {
    //   print("이벤트!!!!!!!!!!! $event.data");
    //   // setState(() {
    //   //   notices = event.data;
    //   // });
    // });
    getNotice(
      success: (dynamic response) async {
        response.listen((event) {
          setState(() {
            notices.insert(0, event.data);
          });
        });
        // setState(() {
        //   notices=response;
        // });
      },
      fail: (error) {
        print('알림: $error');
      },
    );
    super.initState();
  }

  Future<String?> setAccessToken() async {
    final accessToken = await storage.read(key: 'accessToken');
    return accessToken;
  }

  Future<String?> setUserSeq() async {
    final userSeq = await storage.read(key: 'userSeq');
    return userSeq;
  }

  @override
  Widget build(BuildContext context) {
    return Container(
        color: Colors.white,
        // child: Text("hi"),
        child: Column(
          children: [
            SizedBox(
              height: 20,
            ),
            Expanded(
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.center,
                children: [
                  SizedBox(
                    height: 20,
                  ),
                  Text(
                    "알림",
                    style: TextStyle(
                      color: Theme.of(context).secondaryHeaderColor,
                      decoration: TextDecoration.none,
                      fontSize: 15,
                      fontWeight: FontWeight.normal,
                    ),
                  ),
                  SizedBox(
                    height: 15,
                  ),
                  Divider(
                    thickness: 1.5,
                    height: 0,
                  ),
                  Expanded(
                    child: SingleChildScrollView(
                      child: Column(
                        children: [
                          for (var notice in notices)
                            Container(
                              height: 70,
                              width: 1000,
                              margin: EdgeInsets.symmetric(
                                horizontal: 10,
                                vertical: 8,
                              ),
                              decoration: BoxDecoration(
                                color: jsonDecode(notice)['readState']
                                    ? Color(0xFFF9F9F9).withOpacity(0.7)
                                    : Colors.white,
                                borderRadius: BorderRadius.circular(10),
                                boxShadow: [
                                  BoxShadow(
                                    color: Colors.grey.withOpacity(0.6),
                                    blurRadius: 4.0,
                                    spreadRadius: 0.0,
                                  ),
                                ],
                                // border: Border.all(color: jsonDecode(notice)['readState']?Colors.transparent:Theme.of(context).disabledColor)
                              ),
                              child: Row(
                                mainAxisAlignment: MainAxisAlignment.start,
                                crossAxisAlignment: CrossAxisAlignment.start,
                                children: [
                                  // Container(
                                  //   width: 50,
                                  //   height: 50,
                                  //   margin: EdgeInsets.symmetric(
                                  //     horizontal: 10,
                                  //   ),
                                  //   decoration: BoxDecoration(
                                  //       image: DecorationImage(
                                  //         image: AssetImage(
                                  //             'assets/images/no_image.jpg'),
                                  //         fit: BoxFit.cover,
                                  //       ),
                                  //       borderRadius:
                                  //           BorderRadius.circular(100),
                                  //       border: Border.all(
                                  //           color: Theme.of(context)
                                  //               .secondaryHeaderColor
                                  //               .withOpacity(0.3))),
                                  // ),
                                  Container(
                                    width: 7,
                                    height: 7,
                                    margin: EdgeInsets.only(top: 20, left: 10,),
                                    decoration: BoxDecoration(
                                      borderRadius: BorderRadius.circular(100),
                                      color: jsonDecode(notice)['readState']?Colors.transparent:Theme.of(context).disabledColor,
                                    ),
                                  ),
                                  SizedBox(
                                    width: 8,
                                  ),
                                  Column(
                                    crossAxisAlignment:
                                        CrossAxisAlignment.start,
                                    mainAxisAlignment: MainAxisAlignment.center,
                                    children: [
                                      // if (jsonDecode(notice)['type'] == 0)
                                      //   Text(
                                      //     "일촌평",
                                      //     style: TextStyle(
                                      //       color: Theme.of(context)
                                      //           .secondaryHeaderColor,
                                      //       decoration: TextDecoration.none,
                                      //       fontSize: 10,
                                      //       fontWeight: FontWeight.normal,
                                      //     ),
                                      //   ),
                                      // if (jsonDecode(notice)['type'] == 1)
                                      //   Text(
                                      //     "방명록",
                                      //     style: TextStyle(
                                      //       color: Theme.of(context)
                                      //           .secondaryHeaderColor,
                                      //       decoration: TextDecoration.none,
                                      //       fontSize: 10,
                                      //       fontWeight: FontWeight.normal,
                                      //     ),
                                      //   ),
                                      // if (jsonDecode(notice)['type'] == 2)
                                      //   Text(
                                      //     "댓글",
                                      //     style: TextStyle(
                                      //       color: Theme.of(context)
                                      //           .secondaryHeaderColor,
                                      //       decoration: TextDecoration.none,
                                      //       fontSize: 10,
                                      //       fontWeight: FontWeight.normal,
                                      //     ),
                                      //   ),
                                      // if (jsonDecode(notice)['type'] == 3)
                                      //   Text(
                                      //     "일촌 요청 도착",
                                      //     style: TextStyle(
                                      //       color: Theme.of(context)
                                      //           .secondaryHeaderColor,
                                      //       decoration: TextDecoration.none,
                                      //       fontSize: 10,
                                      //       fontWeight: FontWeight.normal,
                                      //     ),
                                      //   ),
                                      // if (jsonDecode(notice)['type'] == 4)
                                      //   Text(
                                      //     "상대방 일촌 수락",
                                      //     style: TextStyle(
                                      //       color: Theme.of(context)
                                      //           .secondaryHeaderColor,
                                      //       decoration: TextDecoration.none,
                                      //       fontSize: 10,
                                      //       fontWeight: FontWeight.normal,
                                      //     ),
                                      //   ),
                                      Text(
                                        "${(jsonDecode(notice))['title']}",
                                        style: TextStyle(
                                          color: Theme.of(context)
                                              .secondaryHeaderColor,
                                          fontSize: 12,
                                          fontWeight: FontWeight.normal,
                                          decoration: TextDecoration.none,
                                        ),
                                      ),
                                      SizedBox(
                                        height: 10,
                                      ),
                                      Text(
                                        "${(jsonDecode(notice))['createdTime'].toString().substring(0, 10)} ${(jsonDecode(notice))['createdTime'].toString().substring(11, 16)}",
                                        style: TextStyle(
                                          color: Theme.of(context)
                                              .secondaryHeaderColor
                                              .withOpacity(0.5),
                                          fontSize: 10,
                                          fontWeight: FontWeight.normal,
                                          decoration: TextDecoration.none,
                                        ),
                                      ),
                                    ],
                                  ),
                                ],
                              ),
                            )
                        ],
                      ),
                    ),
                  ),
                ],
              ),
            ),
          ],
        )
        // child: Text("$notices", style: TextStyle(fontSize: 10,)),
        // child: StreamBuilder(
        //   stream: notices,
        //   builder: (BuildContext context, AsyncSnapshot snapshot) {
        //     if (snapshot.hasData) {
        //       print(snapshot.data.data);
        //     }
        //     print(snapshot.data);
        //     return snapshot.hasData
        //         ? Text(snapshot.data.data,
        //             style: TextStyle(
        //               fontSize: 10,
        //             ))
        //         : Text("");
        //   },
        // ),
        );
  }
}
