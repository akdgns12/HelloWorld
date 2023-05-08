import 'package:flutter/material.dart';
import 'package:app/services/my_page_api.dart';
import 'package:flutter_secure_storage/flutter_secure_storage.dart';

final storage = FlutterSecureStorage();

class MyPageCategory extends StatefulWidget {
  final String category;
  final Color textColor;


  const MyPageCategory({
    super.key,
    required this.category,
    required this.textColor,
  });
  @override
  State<MyPageCategory> createState() => _MyPageCategoryState();
}

enum CategoryName { ModifyInfo, Statistics, MyFamily, NoticeSetting, Logout, Resign }

String convertCategoryNameToKor(CategoryName name) {
  switch (name) {
    case CategoryName.ModifyInfo: return "내 정보 수정";
    case CategoryName.Statistics: return "통계 보기";
    case CategoryName.MyFamily: return "일촌 보기";
    case CategoryName.NoticeSetting: return "알림 설정";
    case CategoryName.Logout: return "로그아웃";
    case CategoryName.Resign: return "회원 탈퇴하기";
  }
}

class _MyPageCategoryState extends State<MyPageCategory> {
  @override
  Widget build(BuildContext context) {
    return TextButton(
      style: ButtonStyle(
        fixedSize: MaterialStatePropertyAll(
            Size(MediaQuery.of(context).size.width, 50)),
        alignment: Alignment.centerLeft,
      ),
      onPressed: () {
        if (widget.category ==
            convertCategoryNameToKor(CategoryName.ModifyInfo)) {
          showDialog(
            context: context,
            builder: (BuildContext context) {
              return Dialog(
                child: SizedBox(
                  height: 300,
                  child: Column(
                    children: [
                      const SizedBox(
                        height: 30,
                      ),
                      TextButton(
                        onPressed: () {
                        },
                        child: Container(
                          width: 110,
                          height: 110,
                          decoration: BoxDecoration(
                            borderRadius: BorderRadius.circular(100),
                            border: Border.all(
                                color: const Color(0xFFD9D9D9), width: 2.5),
                            image: const DecorationImage(
                                image: AssetImage('assets/images/no_image.jpg'),
                              fit: BoxFit.cover,
                            ),
                          ),
                        ),
                      ),
                      Container(
                        padding: EdgeInsets.zero,
                        child: TextButton(
                          onPressed: () {
                          },
                          child: const Row(
                            mainAxisAlignment: MainAxisAlignment.center,
                            children: [
                              Icon(Icons.photo_outlined,
                                  color: Color(0xFF6A6A6A)),
                              SizedBox(
                                width: 3,
                              ),
                              Text(
                                "사진 변경하기",
                                style: TextStyle(
                                  color: Color(0xFF6A6A6A),
                                ),
                              ),
                            ],
                          ),
                        ),
                      ),
                      SizedBox(
                        width: 200,
                        child: TextField(
                          decoration: InputDecoration(
                            contentPadding: const EdgeInsets.only(bottom: 3),
                            isDense: true,
                            border: UnderlineInputBorder(
                              borderSide: BorderSide(
                                color: Theme.of(context).secondaryHeaderColor,
                              ),
                            ),
                          ),
                          style: TextStyle(
                            fontSize: 12,
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          textAlign: TextAlign.center,
                        ),
                      ),
                      TextButton(
                        onPressed: () {
                        },
                        child: Text("수정하기",
                            style: TextStyle(
                                color: Theme.of(context).primaryColor)),
                      )
                    ],
                  ),
                ),
              );
            },
          );
        } else if (widget.category ==
            convertCategoryNameToKor(CategoryName.Statistics)) {
          // Navigator.push(
          //   context,
          //   MaterialPageRoute(builder: (context) => const CarInfo()),
          // );
        } else if (widget.category ==
            convertCategoryNameToKor(CategoryName.MyFamily)) {
          // Navigator.push(
          //   context,
          //   MaterialPageRoute(builder: (context) => const MyFamily()),
          // );
        } else if (widget.category ==
            convertCategoryNameToKor(CategoryName.NoticeSetting)) {
          // Navigator.push(
          //   context,
          //   MaterialPageRoute(builder: (context) => const AlarmSetting()),
          // );
        } else if (widget.category ==
            convertCategoryNameToKor(CategoryName.Logout)) {
            signOut();
        } else if (widget.category ==
            convertCategoryNameToKor(CategoryName.Resign)) {
          showDialog(
            context: context,
            builder: (BuildContext context) {
              return Dialog(
                child: Container(
                  height: 220,
                  padding: const EdgeInsets.symmetric(
                    horizontal: 10,
                    vertical: 15,
                  ),
                  child: Column(
                    mainAxisAlignment: MainAxisAlignment.center,
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text(
                        "원송희 님",
                        style: const TextStyle(
                          height: 2,
                          fontWeight: FontWeight.w600,
                          fontSize: 15,
                        ),
                      ),
                      const SizedBox(height: 5),
                      const Text(
                        "회원님에 대한 정보가 모두 삭제됩니다.\n계속 진행하시겠습니까?",
                        style: TextStyle(height: 2, color: Color(0xFF6A6A6A)),
                      ),
                      const SizedBox(height: 17),
                      Row(
                        mainAxisAlignment: MainAxisAlignment.center,
                        children: [
                          TextButton(
                            onPressed: () => {},
                            child: Container(
                              width: 110,
                              alignment: Alignment.center,
                              padding: const EdgeInsets.symmetric(
                                vertical: 6,
                                horizontal: 20,
                              ),
                              decoration: BoxDecoration(
                                  borderRadius: BorderRadius.circular(10),
                                  color: Theme.of(context).disabledColor),
                              child: const Text(
                                "확인",
                                style: TextStyle(
                                  color: Colors.white,
                                  fontWeight: FontWeight.w600,
                                ),
                              ),
                            ),
                          ),
                          TextButton(
                            onPressed: () => {Navigator.pop(context)},
                            child: Container(
                              width: 110,
                              alignment: Alignment.center,
                              padding: const EdgeInsets.symmetric(
                                vertical: 6,
                                horizontal: 20,
                              ),
                              decoration: BoxDecoration(
                                borderRadius: BorderRadius.circular(10),
                                color: Colors.white,
                                boxShadow: [
                                  BoxShadow(
                                    color: Colors.grey.withOpacity(0.7),
                                    blurRadius: 2.0,
                                    spreadRadius: 0.0,
                                  )
                                ],
                              ),
                              child: const Text(
                                "취소",
                                style: TextStyle(
                                  color: Color(0xFF453F52),
                                ),
                              ),
                            ),
                          ),
                        ],
                      ),
                    ],
                  ),
                ),
              );
            },
          );
        }
      },
      child: Container(
        alignment: Alignment.centerLeft,
        padding: const EdgeInsets.symmetric(
          horizontal: 30,
        ),
        height: 30,
        child: Text(
          widget.category,
          style: TextStyle(
            color: widget.textColor,
            fontSize: 15,
            fontWeight: FontWeight.w600,
            decoration: TextDecoration.none,
          ),
        ),
      ),
    );
  }

  resign() {
    deleteUserInfo(
      success: (dynamic response) {},
      fail: (error) {
        print('회원 탈퇴 오류: $error');
        Navigator.pushNamedAndRemoveUntil(
          context,
          '/error',
          arguments: {
            'errorText': error,
          },
          ModalRoute.withName('/home'),
        );
      },
    );
  }

  signOut() async{
    Future<String?> futureString = storage.read(key: "accessToken");
    String? accessToken = await futureString;
    logout(
      success: (dynamic response) async {
        await storage.deleteAll();
        Navigator.pushNamed(context, "/before-login");
      },
      fail: (error) {
        print('로그아웃 오류: $error');
        Navigator.pushNamedAndRemoveUntil(
          context,
          '/error',
          arguments: {
            'errorText': error,
          },
          ModalRoute.withName('/home'),
        );
      },
      body: {"accessToken": "$accessToken"}
    );
  }
}
