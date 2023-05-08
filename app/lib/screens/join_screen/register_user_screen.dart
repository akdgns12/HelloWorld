import 'package:flutter/material.dart';
import 'package:app/widgets/logo_widget/logo_widget.dart';

class RegisterUser extends StatefulWidget {
  const RegisterUser({Key? key}) : super(key: key);

  @override
  State<RegisterUser> createState() => _RegisterUserState();
}

class _RegisterUserState extends State<RegisterUser> {
  var emailController = TextEditingController();
  var pwController = TextEditingController();
  var pw2Controller = TextEditingController();
  var nameController = TextEditingController();
  var nicknameController = TextEditingController();
  var phoneNumController = TextEditingController();

  bool emailChk = false;
  bool pwCheck = false;
  bool pw2Check = false;

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
                  width: 80,
                  height: 160,
                  fontSize: 40,
                ),
                Container(
                  width: 300,
                  // color: Colors.red,
                  child: Form(
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
                            onChanged: (text) {
                              Pattern pattern =
                                  r'^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$';
                              RegExp regExp = new RegExp(pattern.toString());
                              if (!regExp.hasMatch(text)) {
                                setState(() {
                                  emailChk = false;
                                });
                              } else {
                                setState(() {
                                  emailChk = true;
                                });
                              }
                            },
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
                        emailChk
                            ? Text(
                                "",
                                style: TextStyle(
                                  fontSize: 10,
                                ),
                              )
                            : Text(
                                "올바르지 않은 이메일 형식입니다",
                                style: TextStyle(
                                  color: Theme.of(context).disabledColor,
                                  fontSize: 10,
                                ),
                              ),
                        SizedBox(
                          height: 10,
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
                            onChanged: (text) {
                              Pattern pattern = r'^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?~^<>,.&+=])[A-Za-z\d$@$!%*#?~^<>,.&+=]{8,15}$';
                              RegExp regExp = new RegExp(pattern.toString());
                              if(!regExp.hasMatch(text)) {
                                setState(() {
                                  pwCheck = false;
                                });
                              }
                              else {
                                setState(() {
                                  pwCheck = true;
                                });
                              }
                            },
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
                        pwCheck
                            ? Text(
                          "",
                          style: TextStyle(
                            fontSize: 10,
                          ),
                        )
                            : Text(
                          "비밀번호는 8자 이상이어야 하며, 숫자/대문자/소문자/특수문자(#?!@\$%^&*-)를 모두 포함해야 합니다",
                          style: TextStyle(
                            color: Theme.of(context).disabledColor,
                            fontSize: 10,
                          ),
                        ),
                        SizedBox(
                          height: 10,
                        ),
                        Text(
                          "비밀번호 확인",
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
                            controller: pw2Controller,
                            onChanged: (text) {
                              if (text != pwController.text) {
                                setState(() {
                                  pw2Check = false;
                                });
                              }
                              else {
                                setState(() {
                                  pw2Check = true;
                                });
                              }
                            },
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
                        pw2Check
                            ? Text(
                          "",
                          style: TextStyle(
                            fontSize: 10,
                          ),
                        )
                            : Text(
                          "비밀번호와 비밀번호 확인란이 일치하지 않습니다",
                          style: TextStyle(
                            color: Theme.of(context).disabledColor,
                            fontSize: 10,
                          ),
                        ),
                        SizedBox(
                          height: 10,
                        ),
                        Text(
                          "이름",
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
                            controller: nameController,
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
                          "닉네임",
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
                            controller: nicknameController,
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
                          "핸드폰 번호",
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
                            controller: phoneNumController,
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
                ),
                SizedBox(
                  height: 20,
                ),
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    TextButton(
                      onPressed: cancel,
                      child: Container(
                        width: 140,
                        height: 40,
                        alignment: Alignment.center,
                        child: Text(
                          "취소",
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
                    TextButton(
                      onPressed: next,
                      child: Container(
                        width: 140,
                        height: 40,
                        alignment: Alignment.center,
                        child: Text(
                          "다음",
                          style: TextStyle(
                            color: Color(0xFFFFFFFF),
                          ),
                        ),
                        decoration: BoxDecoration(
                          color: Theme.of(context).primaryColorLight,
                          borderRadius: BorderRadius.circular(7),
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

  cancel() {
    Navigator.pushNamed(context, '/before-login');
  }


  canGoNext() {
    if(emailChk && pwCheck && pw2Check && emailController.text != '' &&
        pwController.text != '' && pw2Controller.text != '' && nameController.text != ''
        && nicknameController.text != '' && phoneNumController.text != '') {
      return true;
    }
    return false;
  }

  next() {
    if (canGoNext()) {
      Navigator.pushNamed(
        context,
        '/register-character',
        arguments: {
          'email': emailController.text,
          'pw': pwController.text,
          'name': nameController.text,
          'nickname': nicknameController.text,
          'phoneNum': phoneNumController.text,
        },
      );
    }
    else {
      print("NO");
    }
  }
}
