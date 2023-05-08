import 'package:flutter/material.dart';
import 'package:app/widgets/logo_widget/logo_widget.dart';
import 'package:app/services/user_api.dart';
import 'package:flutter_client_sse/flutter_client_sse.dart';
import 'package:flutter_secure_storage/flutter_secure_storage.dart';

class Login extends StatefulWidget {
  const Login({Key? key}) : super(key: key);

  @override
  State<Login> createState() => _LoginState();
}

class _LoginState extends State<Login> {
  static const storage =
      FlutterSecureStorage(); // FlutterSecureStorage를 storage로 저장
  var emailController = TextEditingController();
  var pwController = TextEditingController();

  Map<String, String> _buildLoginInfoBody() {
    return {
      "email": emailController.text,
      "password": pwController.text,
    };
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Color(0xFFFFFFFF),
      body: Center(
        child: SafeArea(
          child: SingleChildScrollView(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Logo(
                  width: 100,
                  height: 200,
                  fontSize: 50,
                ),
                Container(
                  width: 300,
                  // color: Colors.red,
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text(
                        "이메일",
                        textAlign: TextAlign.start,
                        style: TextStyle(
                          fontSize: 12,
                          color: Theme.of(context).primaryColorLight,
                          fontWeight: FontWeight.w600,
                        ),
                      ),
                      SizedBox(
                        height: 5,
                      ),
                      Container(
                        height: 30,
                        child: TextField(
                          controller: emailController,
                          decoration: InputDecoration(
                            border: OutlineInputBorder(
                              borderSide: BorderSide(
                                  color:
                                      Theme.of(context).secondaryHeaderColor),
                              borderRadius: BorderRadius.circular(5),
                            ),
                            contentPadding: EdgeInsets.symmetric(
                              horizontal: 8,
                            ),
                          ),
                        ),
                      ),
                      SizedBox(
                        height: 20,
                      ),
                      Text(
                        "비밀번호",
                        textAlign: TextAlign.start,
                        style: TextStyle(
                          fontSize: 12,
                          color: Theme.of(context).primaryColorLight,
                          fontWeight: FontWeight.w600,
                        ),
                      ),
                      SizedBox(
                        height: 5,
                      ),
                      Container(
                        height: 30,
                        child: TextField(
                          obscureText: true,
                          controller: pwController,
                          decoration: InputDecoration(
                            border: OutlineInputBorder(
                              borderSide: BorderSide(
                                  color:
                                      Theme.of(context).secondaryHeaderColor),
                              borderRadius: BorderRadius.circular(5),
                            ),
                            contentPadding: EdgeInsets.symmetric(
                              horizontal: 8,
                            ),
                          ),
                        ),
                      ),
                    ],
                  ),
                ),
                SizedBox(
                  height: 20,
                ),
                TextButton(
                  onPressed: () {
                    login(
                      success: (dynamic response) async {
                        await storage.write(
                          key: "accessToken",
                          value: response['data']['accessToken']
                        );
                        await storage.write(
                            key: "userSeq",
                            value: response['data']['userSeq'].toString(),
                        );
                        print("어세스!!!! $response['data']['accessToken']");
                        Navigator.pushNamed(context, '/home');
                      },
                      fail: (error) {
                        print('로그인: $error');
                      },
                      body: _buildLoginInfoBody(),
                    );
                  },
                  child: Container(
                    width: 300,
                    height: 40,
                    alignment: Alignment.center,
                    child: Text(
                      "로그인",
                      style: TextStyle(
                        color: Color(0xFFFFFFFF),
                      ),
                    ),
                    decoration: BoxDecoration(
                      color: Theme.of(context).disabledColor,
                      borderRadius: BorderRadius.circular(7),
                    ),
                  ),
                ),
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    TextButton(
                      onPressed: mvFindPw,
                      child: Text(
                        "비밀번호 찾기",
                        style: TextStyle(
                          color: Theme.of(context).secondaryHeaderColor,
                          fontSize: 10,
                        ),
                      ),
                    ),
                    Text(
                      "|",
                      style: TextStyle(
                        color: Theme.of(context).secondaryHeaderColor,
                        fontSize: 10,
                      ),
                    ),
                    TextButton(
                      onPressed: mvJoin,
                      child: Text(
                        "회원가입",
                        style: TextStyle(
                          color: Theme.of(context).secondaryHeaderColor,
                          fontSize: 10,
                        ),
                      ),
                    ),
                    Text(
                      "|",
                      style: TextStyle(
                        color: Theme.of(context).secondaryHeaderColor,
                        fontSize: 10,
                      ),
                    ),
                    TextButton(
                      onPressed: loginWithGithub,
                      child: Text(
                        "Github으로 로그인",
                        style: TextStyle(
                          color: Theme.of(context).secondaryHeaderColor,
                          fontSize: 10,
                        ),
                      ),
                    ),
                  ],
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }

  loginWithGithub() {}

  mvFindPw() {
    Navigator.pushNamed(context, '/find-pw');
  }

  mvJoin() {
    Navigator.pushNamed(context, '/register-user');
  }
}
