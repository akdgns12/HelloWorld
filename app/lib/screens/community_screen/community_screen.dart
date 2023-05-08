import 'package:flutter/material.dart';
import 'package:app/widgets/common/header.dart';
import 'package:app/widgets/common/footer.dart';
import 'package:app/services/board_api.dart';
import 'package:app/services/user_api.dart';

class Community extends StatefulWidget {
  const Community({Key? key}) : super(key: key);

  @override
  State<Community> createState() => _CommunityState();
}

class _CommunityState extends State<Community> {
  dynamic boardList = [];
  dynamic userName = "";

  @override
  void initState() {
    getBoardList(success: (dynamic response) {
      print(response['body']);
      setState(() {
        boardList = response['body'];
      });
    }, fail: (error) {
      print('게시글 호출 오류: $error');
    });

    getUserInfo(
      success: (dynamic response) {
        setState(() {
          userName = response['data']['nickname'];
        });
      },
      fail: (error) {
        print('유저정보 조회: $error');
      },
    );
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      color: Colors.white,
      child: Column(
        children: [
          Container(
            height: 60,
            padding: const EdgeInsets.symmetric(horizontal: 8),
            margin: const EdgeInsets.only(top: 25),
            // color: Theme.of(context).primaryColorLight,
            child: Row(
              crossAxisAlignment: CrossAxisAlignment.center,
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                Container(
                  margin: EdgeInsets.only(
                    left: 10,
                  ),
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      RichText(
                        text: TextSpan(
                          children: [
                            TextSpan(
                              text: userName,
                              style: TextStyle(
                                color: Theme.of(context).primaryColorLight,
                                fontSize: 20,
                                fontWeight: FontWeight.w700,
                              ),
                            ),
                            TextSpan(
                              text: ' 님에게 추천하는 게시글 ',
                              style: TextStyle(
                                fontSize: 16,
                                fontWeight: FontWeight.normal,
                                color: Theme.of(context).secondaryHeaderColor,
                              ),
                            ),
                          ],
                        ),
                      ),
                    ],
                  ),
                ),
                // TextButton(
                //   onPressed: mvNotice,
                //   child: Icon(
                //     Icons.notifications_active_outlined,
                //     color: Colors.grey,
                //     size: 30,
                //   ),
                // ),
              ],
            ),
          ),
          Expanded(
            child: SingleChildScrollView(
              child: Column(
                children: [
                  for (var board in boardList)
                    GestureDetector(
                      onTap: () {
                        // 여기에 게시글 상세로 이동하는 링크 달기
                        print(board['boardSeq']);
                      },
                      child: Container(
                        margin: EdgeInsets.symmetric(
                          horizontal: 10,
                          vertical: 8,
                        ),
                        padding: EdgeInsets.symmetric(
                          horizontal: 10,
                          vertical: 15,
                        ),
                        width: 1000,
                        height: 415,
                        decoration: BoxDecoration(
                          border: Border.all(
                            color: Color(0xFFF9F9F9),
                            width: 1.5,
                          ),
                          borderRadius: BorderRadius.circular(15),
                          boxShadow: [
                            BoxShadow(
                              color: Colors.grey.withOpacity(0.6),
                              blurRadius: 4.0,
                              spreadRadius: 0.0,
                            ),
                          ],
                          color: Colors.white,
                        ),
                        child: Column(
                          crossAxisAlignment: CrossAxisAlignment.start,
                          children: [
                            Container(
                              width: 1000,
                              height: 260,
                              padding: EdgeInsets.symmetric(
                                horizontal: 10,
                              ),
                              decoration: BoxDecoration(
                                border: Border.all(
                                    color: Theme.of(context).shadowColor,
                                    width: 2),
                                borderRadius: BorderRadius.circular(
                                  10,
                                ),
                                image: DecorationImage(
                                  image:
                                      AssetImage('assets/images/no_image.jpg'),
                                  fit: BoxFit.cover,
                                ),
                              ),
                            ),
                            SizedBox(
                              height: 7,
                            ),
                            Text(
                              board['title'],
                              maxLines: 1,
                              overflow: TextOverflow.ellipsis,
                              style: TextStyle(
                                color: Theme.of(context).secondaryHeaderColor,
                                fontSize: 18,
                                fontWeight: FontWeight.w600,
                                decoration: TextDecoration.none,
                              ),
                            ),
                            SizedBox(
                              height: 3,
                            ),
                            Text(
                              "by ${board['writer']}",
                              style: TextStyle(
                                color: Theme.of(context).secondaryHeaderColor,
                                fontSize: 10,
                                fontWeight: FontWeight.normal,
                                decoration: TextDecoration.none,
                              ),
                            ),
                            SizedBox(
                              height: 10,
                            ),
                            Text(
                              "내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다",
                              maxLines: 2,
                              overflow: TextOverflow.ellipsis,
                              style: TextStyle(
                                color: Theme.of(context).secondaryHeaderColor,
                                fontSize: 12,
                                decoration: TextDecoration.none,
                                fontWeight: FontWeight.normal,
                              ),
                            ),
                            Divider(
                              thickness: 1.5,
                              height: 25,
                            ),
                            Row(
                              mainAxisAlignment: MainAxisAlignment.end,
                              children: [
                                Icon(Icons.favorite_border,
                                    size: 17,
                                    color:
                                        Theme.of(context).secondaryHeaderColor),
                                SizedBox(
                                  width: 3,
                                ),
                                Text(
                                  "132",
                                  style: TextStyle(
                                    color:
                                        Theme.of(context).secondaryHeaderColor,
                                    fontSize: 11,
                                    fontWeight: FontWeight.normal,
                                    decoration: TextDecoration.none,
                                  ),
                                ),
                                SizedBox(
                                  width: 12,
                                ),
                                Icon(Icons.mode_comment_outlined,
                                    size: 17,
                                    color:
                                        Theme.of(context).secondaryHeaderColor),
                                SizedBox(
                                  width: 3,
                                ),
                                Text(
                                  "17",
                                  style: TextStyle(
                                    color:
                                        Theme.of(context).secondaryHeaderColor,
                                    fontSize: 11,
                                    fontWeight: FontWeight.normal,
                                    decoration: TextDecoration.none,
                                  ),
                                ),
                              ],
                            ),
                          ],
                        ),
                      ),
                    ),
                ],
              ),
            ),
          ),
          Footer(),
        ],
      ),
    );
  }

// mvNotice() {
//   Navigator.pushNamed(context, "/notice");
// }
}
