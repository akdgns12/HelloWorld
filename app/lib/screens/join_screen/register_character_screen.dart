import 'package:flutter/material.dart';
import 'package:smooth_page_indicator/smooth_page_indicator.dart';
import 'dart:io';
import 'dart:async';
import 'dart:ui' as ui;
import 'dart:typed_data';
import 'package:flutter/rendering.dart';
import 'package:flutter/services.dart';
import 'package:path_provider/path_provider.dart';
import 'package:app/services/user_api.dart';

class RegisterCharacter extends StatefulWidget {
  const RegisterCharacter({Key? key}) : super(key: key);

  @override
  State<RegisterCharacter> createState() => _RegisterCharacterState();
}

class _RegisterCharacterState extends State<RegisterCharacter> {
  var globalKey = new GlobalKey();
  final _petController = PageController(viewportFraction: 1, keepPage: true);
  final _hairController = PageController(viewportFraction: 1, keepPage: true);
  final _emotionController =
      PageController(viewportFraction: 1, keepPage: true);
  final _shirtController = PageController(viewportFraction: 1, keepPage: true);
  final _pantsController = PageController(viewportFraction: 1, keepPage: true);
  late String petNum = '';
  late String hairNum = '';
  late String emotionNum = '';
  late String shirtNum = '';
  late String pantsNum = '';


  @override
  Widget build(BuildContext context) {
    Map<String, String> _buildUserInfoBody() {
      final args =
      ModalRoute.of(context)?.settings.arguments as Map<String, String?>?;
      return {
        "email": args!['email'].toString(),
        "name": args!['name'].toString(),
        "nickname": args!['nickname'].toString(),
        "password": args!['pw'].toString(),
        "phoneNumber": args!['phoneNum'].toString(),
      };
    }
    // void join() {
    //
    //   Navigator.pushNamed(context, '/login');
    // }

    return Scaffold(
      backgroundColor: Color(0xFFFFFFFF),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            RepaintBoundary(
              key: globalKey,
              child: Stack(
                alignment: Alignment.center,
                children: [
                  Container(
                    width: 100,
                    height: 100,
                    decoration: BoxDecoration(
                      image: DecorationImage(
                        image: AssetImage('assets/images/basic_avatar.png'),
                        fit: BoxFit.fill,
                      ),
                      border: Border.all(
                          color: Theme.of(context).secondaryHeaderColor),
                      borderRadius: BorderRadius.circular(15),
                    ),
                  ),
                  hairNum != ''
                      ? Container(
                          width: 100,
                          height: 100,
                          decoration: BoxDecoration(
                            image: DecorationImage(
                              image: AssetImage(
                                  'assets/images/hair/pixil-layer-${hairNum}.png'),
                              fit: BoxFit.fill,
                            ),
                          ),
                        )
                      : Container(),
                  petNum != ''
                      ? Container(
                          width: 100,
                          height: 100,
                          decoration: BoxDecoration(
                            image: DecorationImage(
                              image: AssetImage(
                                  'assets/images/pet/pixil-layer-${petNum}.png'),
                              fit: BoxFit.fill,
                            ),
                          ),
                        )
                      : Container(),
                  emotionNum != ''
                      ? Container(
                          width: 100,
                          height: 100,
                          decoration: BoxDecoration(
                            image: DecorationImage(
                              image: AssetImage(
                                  'assets/images/emotion/pixil-layer-${emotionNum}.png'),
                              fit: BoxFit.fill,
                            ),
                          ),
                        )
                      : Container(),
                  shirtNum != ''
                      ? Container(
                          width: 100,
                          height: 100,
                          decoration: BoxDecoration(
                            image: DecorationImage(
                              image: AssetImage(
                                  'assets/images/shirt/pixil-layer-${shirtNum}.png'),
                              fit: BoxFit.fill,
                            ),
                          ),
                        )
                      : Container(),
                  pantsNum != ''
                      ? Container(
                          width: 100,
                          height: 100,
                          decoration: BoxDecoration(
                            image: DecorationImage(
                              image: AssetImage(
                                  'assets/images/pants/pixil-layer-${pantsNum}.png'),
                              fit: BoxFit.fill,
                            ),
                          ),
                        )
                      : Container(),
                ],
              ),
            ),
            SizedBox(
              height: 10,
            ),
            Container(
              alignment: Alignment.centerLeft,
              margin: EdgeInsets.only(
                left: 20,
              ),
              child: Text(
                "헤어",
                style: TextStyle(
                  fontSize: 12,
                ),
                textAlign: TextAlign.start,
              ),
            ),
            SizedBox(
              height: 5,
            ),
            Container(
              width: 800,
              height: 50,
              child: PageView(
                allowImplicitScrolling: false,
                controller: _hairController,
                children: [
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                    children: [
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/hair/pixil-layer-1.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (hairNum == '1') {
                                hairNum = '';
                              } else {
                                hairNum = '1';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/hair/pixil-layer-2.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (hairNum == '2') {
                                hairNum = '';
                              } else {
                                hairNum = '2';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/hair/pixil-layer-3.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (hairNum == '3') {
                                hairNum = '';
                              } else {
                                hairNum = '3';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/hair/pixil-layer-4.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (hairNum == '4') {
                                hairNum = '';
                              } else {
                                hairNum = '4';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/hair/pixil-layer-5.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (hairNum == '5') {
                                hairNum = '';
                              } else {
                                hairNum = '5';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                    ],
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                    children: [
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/hair/pixil-layer-6.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (hairNum == '6') {
                                hairNum = '';
                              } else {
                                hairNum = '6';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/hair/pixil-layer-7.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (hairNum == '7') {
                                hairNum = '';
                              } else {
                                hairNum = '7';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/hair/pixil-layer-8.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (hairNum == '8') {
                                hairNum = '';
                              } else {
                                hairNum = '8';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/hair/pixil-layer-9.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (hairNum == '9') {
                                hairNum = '';
                              } else {
                                hairNum = '9';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/hair/pixil-layer-10.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (hairNum == '10') {
                                hairNum = '';
                              } else {
                                hairNum = '10';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                    ],
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                    children: [
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/hair/pixil-layer-11.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (hairNum == '11') {
                                hairNum = '';
                              } else {
                                hairNum = '11';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/hair/pixil-layer-12.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (hairNum == '12') {
                                hairNum = '';
                              } else {
                                hairNum = '12';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/hair/pixil-layer-13.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (hairNum == '13') {
                                hairNum = '';
                              } else {
                                hairNum = '13';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/hair/pixil-layer-14.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (hairNum == '14') {
                                hairNum = '';
                              } else {
                                hairNum = '14';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/hair/pixil-layer-15.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (hairNum == '15') {
                                hairNum = '';
                              } else {
                                hairNum = '15';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                    ],
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                    children: [
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/hair/pixil-layer-16.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (hairNum == '16') {
                                hairNum = '';
                              } else {
                                hairNum = '16';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/hair/pixil-layer-17.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (hairNum == '17') {
                                hairNum = '';
                              } else {
                                hairNum = '17';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/hair/pixil-layer-18.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (hairNum == '18') {
                                hairNum = '';
                              } else {
                                hairNum = '18';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/hair/pixil-layer-19.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (hairNum == '19') {
                                hairNum = '';
                              } else {
                                hairNum = '19';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/hair/pixil-layer-20.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (hairNum == '20') {
                                hairNum = '';
                              } else {
                                hairNum = '20';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                    ],
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                    children: [
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/hair/pixil-layer-21.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (hairNum == '21') {
                                hairNum = '';
                              } else {
                                hairNum = '21';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/hair/pixil-layer-22.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (hairNum == '22') {
                                hairNum = '';
                              } else {
                                hairNum = '22';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/hair/pixil-layer-23.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (hairNum == '23') {
                                hairNum = '';
                              } else {
                                hairNum = '23';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/hair/pixil-layer-24.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (hairNum == '24') {
                                hairNum = '';
                              } else {
                                hairNum = '24';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/hair/pixil-layer-25.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (hairNum == '25') {
                                hairNum = '';
                              } else {
                                hairNum = '25';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                    ],
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                    children: [
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/hair/pixil-layer-26.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (hairNum == '26') {
                                hairNum = '';
                              } else {
                                hairNum = '26';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/hair/pixil-layer-27.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (hairNum == '27') {
                                hairNum = '';
                              } else {
                                hairNum = '27';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/hair/pixil-layer-28.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (hairNum == '28') {
                                hairNum = '';
                              } else {
                                hairNum = '28';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/hair/pixil-layer-29.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (hairNum == '29') {
                                hairNum = '';
                              } else {
                                hairNum = '29';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/hair/pixil-layer-30.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (hairNum == '30') {
                                hairNum = '';
                              } else {
                                hairNum = '30';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                    ],
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                    children: [
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/hair/pixil-layer-31.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (hairNum == '31') {
                                hairNum = '';
                              } else {
                                hairNum = '31';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/hair/pixil-layer-32.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (hairNum == '32') {
                                hairNum = '';
                              } else {
                                hairNum = '32';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/hair/pixil-layer-33.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (hairNum == '33') {
                                hairNum = '';
                              } else {
                                hairNum = '33';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/hair/pixil-layer-34.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (hairNum == '34') {
                                hairNum = '';
                              } else {
                                hairNum = '34';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/hair/pixil-layer-35.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (hairNum == '35') {
                                hairNum = '';
                              } else {
                                hairNum = '35';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                    ],
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                    children: [
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/hair/pixil-layer-36.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (hairNum == '36') {
                                hairNum = '';
                              } else {
                                hairNum = '36';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/hair/pixil-layer-37.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (hairNum == '37') {
                                hairNum = '';
                              } else {
                                hairNum = '37';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/hair/pixil-layer-38.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (hairNum == '38') {
                                hairNum = '';
                              } else {
                                hairNum = '38';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/hair/pixil-layer-39.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (hairNum == '39') {
                                hairNum = '';
                              } else {
                                hairNum = '39';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/hair/pixil-layer-40.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (hairNum == '40') {
                                hairNum = '';
                              } else {
                                hairNum = '40';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                    ],
                  ),
                ],
              ),
            ),
            SizedBox(
              height: 10,
            ),
            SmoothPageIndicator(
              controller: _hairController, // PageController
              count: 8,
              effect: JumpingDotEffect(
                activeDotColor: Theme.of(context).disabledColor,
                dotHeight: 5,
                dotWidth: 5,
              ),
            ),
            SizedBox(
              height: 10,
            ),
            Container(
              alignment: Alignment.centerLeft,
              margin: EdgeInsets.only(
                left: 20,
              ),
              child: Text(
                "펫",
                style: TextStyle(
                  fontSize: 12,
                ),
                textAlign: TextAlign.start,
              ),
            ),
            SizedBox(
              height: 5,
            ),
            Container(
              width: 800,
              height: 50,
              child: PageView(
                allowImplicitScrolling: false,
                controller: _petController,
                children: [
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                    children: [
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/pet/pixil-layer-1.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (petNum == '1') {
                                petNum = '';
                              } else {
                                petNum = '1';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/pet/pixil-layer-2.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (petNum == '2') {
                                petNum = '';
                              } else {
                                petNum = '2';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/pet/pixil-layer-3.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (petNum == '3') {
                                petNum = '';
                              } else {
                                petNum = '3';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/pet/pixil-layer-4.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (petNum == '4') {
                                petNum = '';
                              } else {
                                petNum = '4';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/pet/pixil-layer-5.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (petNum == '5') {
                                petNum = '';
                              } else {
                                petNum = '5';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                    ],
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                    children: [
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/pet/pixil-layer-6.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (petNum == '6') {
                                petNum = '';
                              } else {
                                petNum = '6';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/pet/pixil-layer-7.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (petNum == '7') {
                                petNum = '';
                              } else {
                                petNum = '7';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/pet/pixil-layer-8.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (petNum == '8') {
                                petNum = '';
                              } else {
                                petNum = '8';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/pet/pixil-layer-9.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (petNum == '9') {
                                petNum = '';
                              } else {
                                petNum = '9';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/pet/pixil-layer-10.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (petNum == '10') {
                                petNum = '';
                              } else {
                                petNum = '10';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                    ],
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                    children: [
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/pet/pixil-layer-11.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (petNum == '11') {
                                petNum = '';
                              } else {
                                petNum = '11';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/pet/pixil-layer-12.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (petNum == '12') {
                                petNum = '';
                              } else {
                                petNum = '12';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/pet/pixil-layer-13.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (petNum == '13') {
                                petNum = '';
                              } else {
                                petNum = '13';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/pet/pixil-layer-14.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (petNum == '14') {
                                petNum = '';
                              } else {
                                petNum = '14';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/pet/pixil-layer-15.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (petNum == '15') {
                                petNum = '';
                              } else {
                                petNum = '15';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                    ],
                  ),
                ],
              ),
            ),
            SizedBox(
              height: 10,
            ),
            SmoothPageIndicator(
              controller: _petController, // PageController
              count: 3,
              effect: JumpingDotEffect(
                activeDotColor: Theme.of(context).disabledColor,
                dotHeight: 5,
                dotWidth: 5,
              ),
            ),
            SizedBox(
              height: 10,
            ),
            Container(
              alignment: Alignment.centerLeft,
              margin: EdgeInsets.only(
                left: 20,
              ),
              child: Text(
                "감정표현",
                style: TextStyle(
                  fontSize: 12,
                ),
                textAlign: TextAlign.start,
              ),
            ),
            SizedBox(
              height: 5,
            ),
            Container(
              width: 800,
              height: 50,
              child: PageView(
                allowImplicitScrolling: false,
                controller: _emotionController,
                children: [
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                    children: [
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/emotion/pixil-layer-1.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (emotionNum == '1') {
                                emotionNum = '';
                              } else {
                                emotionNum = '1';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/emotion/pixil-layer-2.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (emotionNum == '2') {
                                emotionNum = '';
                              } else {
                                emotionNum = '2';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/emotion/pixil-layer-3.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (emotionNum == '3') {
                                emotionNum = '';
                              } else {
                                emotionNum = '3';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/emotion/pixil-layer-4.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (emotionNum == '4') {
                                emotionNum = '';
                              } else {
                                emotionNum = '4';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/emotion/pixil-layer-5.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (emotionNum == '5') {
                                emotionNum = '';
                              } else {
                                emotionNum = '5';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                    ],
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                    children: [
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/emotion/pixil-layer-6.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (emotionNum == '6') {
                                emotionNum = '';
                              } else {
                                emotionNum = '6';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/emotion/pixil-layer-7.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (emotionNum == '7') {
                                emotionNum = '';
                              } else {
                                emotionNum = '7';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/emotion/pixil-layer-8.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (emotionNum == '8') {
                                emotionNum = '';
                              } else {
                                emotionNum = '8';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/emotion/pixil-layer-9.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (emotionNum == '9') {
                                emotionNum = '';
                              } else {
                                emotionNum = '9';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/emotion/pixil-layer-10.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (emotionNum == '10') {
                                emotionNum = '';
                              } else {
                                emotionNum = '10';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                    ],
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                    children: [
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/emotion/pixil-layer-11.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (emotionNum == '11') {
                                emotionNum = '';
                              } else {
                                emotionNum = '11';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/emotion/pixil-layer-12.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (emotionNum == '12') {
                                emotionNum = '';
                              } else {
                                emotionNum = '12';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/emotion/pixil-layer-13.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (emotionNum == '13') {
                                emotionNum = '';
                              } else {
                                emotionNum = '13';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/emotion/pixil-layer-14.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (emotionNum == '14') {
                                emotionNum = '';
                              } else {
                                emotionNum = '14';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/emotion/pixil-layer-15.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (emotionNum == '15') {
                                emotionNum = '';
                              } else {
                                emotionNum = '15';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                    ],
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                    children: [
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/emotion/pixil-layer-16.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (emotionNum == '16') {
                                emotionNum = '';
                              } else {
                                emotionNum = '16';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/emotion/pixil-layer-17.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (emotionNum == '17') {
                                emotionNum = '';
                              } else {
                                emotionNum = '17';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/emotion/pixil-layer-18.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (emotionNum == '18') {
                                emotionNum = '';
                              } else {
                                emotionNum = '18';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/emotion/pixil-layer-19.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (emotionNum == '19') {
                                emotionNum = '';
                              } else {
                                emotionNum = '19';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/emotion/pixil-layer-20.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (emotionNum == '20') {
                                emotionNum = '';
                              } else {
                                emotionNum = '20';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                    ],
                  ),
                ],
              ),
            ),
            SizedBox(
              height: 10,
            ),
            SmoothPageIndicator(
              controller: _emotionController, // PageController
              count: 4,
              effect: JumpingDotEffect(
                activeDotColor: Theme.of(context).disabledColor,
                dotHeight: 5,
                dotWidth: 5,
              ),
            ),
            SizedBox(
              height: 10,
            ),
            Container(
              alignment: Alignment.centerLeft,
              margin: EdgeInsets.only(
                left: 20,
              ),
              child: Text(
                "상의",
                style: TextStyle(
                  fontSize: 12,
                ),
                textAlign: TextAlign.start,
              ),
            ),
            SizedBox(
              height: 5,
            ),
            Container(
              width: 800,
              height: 50,
              child: PageView(
                allowImplicitScrolling: false,
                controller: _shirtController,
                children: [
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                    children: [
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/shirt/pixil-layer-1.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (shirtNum == '1') {
                                shirtNum = '';
                              } else {
                                shirtNum = '1';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/shirt/pixil-layer-2.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (shirtNum == '2') {
                                shirtNum = '';
                              } else {
                                shirtNum = '2';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/shirt/pixil-layer-3.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (shirtNum == '3') {
                                shirtNum = '';
                              } else {
                                shirtNum = '3';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/shirt/pixil-layer-4.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (shirtNum == '4') {
                                shirtNum = '';
                              } else {
                                shirtNum = '4';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/shirt/pixil-layer-5.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (shirtNum == '5') {
                                shirtNum = '';
                              } else {
                                shirtNum = '5';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                    ],
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                    children: [
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/shirt/pixil-layer-6.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (shirtNum == '6') {
                                shirtNum = '';
                              } else {
                                shirtNum = '6';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/shirt/pixil-layer-7.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (shirtNum == '7') {
                                shirtNum = '';
                              } else {
                                shirtNum = '7';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/shirt/pixil-layer-8.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (shirtNum == '8') {
                                shirtNum = '';
                              } else {
                                shirtNum = '8';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/shirt/pixil-layer-9.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (shirtNum == '9') {
                                shirtNum = '';
                              } else {
                                shirtNum = '9';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/shirt/pixil-layer-10.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (shirtNum == '10') {
                                shirtNum = '';
                              } else {
                                shirtNum = '10';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                    ],
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                    children: [
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/shirt/pixil-layer-11.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (shirtNum == '11') {
                                shirtNum = '';
                              } else {
                                shirtNum = '11';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/shirt/pixil-layer-12.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (shirtNum == '12') {
                                shirtNum = '';
                              } else {
                                shirtNum = '12';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/shirt/pixil-layer-13.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (shirtNum == '13') {
                                shirtNum = '';
                              } else {
                                shirtNum = '13';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/shirt/pixil-layer-14.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (shirtNum == '14') {
                                shirtNum = '';
                              } else {
                                shirtNum = '14';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/shirt/pixil-layer-15.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (shirtNum == '15') {
                                shirtNum = '';
                              } else {
                                shirtNum = '15';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                    ],
                  ),
                ],
              ),
            ),
            SizedBox(
              height: 10,
            ),
            SmoothPageIndicator(
              controller: _shirtController, // PageController
              count: 3,
              effect: JumpingDotEffect(
                activeDotColor: Theme.of(context).disabledColor,
                dotHeight: 5,
                dotWidth: 5,
              ),
            ),
            SizedBox(
              height: 10,
            ),
            Container(
              alignment: Alignment.centerLeft,
              margin: EdgeInsets.only(
                left: 20,
              ),
              child: Text(
                "하의",
                style: TextStyle(
                  fontSize: 12,
                ),
                textAlign: TextAlign.start,
              ),
            ),
            SizedBox(
              height: 5,
            ),
            Container(
              width: 800,
              height: 50,
              child: PageView(
                allowImplicitScrolling: false,
                controller: _pantsController,
                children: [
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                    children: [
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/pants/pixil-layer-1.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (pantsNum == '1') {
                                pantsNum = '';
                              } else {
                                pantsNum = '1';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/pants/pixil-layer-2.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (pantsNum == '2') {
                                pantsNum = '';
                              } else {
                                pantsNum = '2';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/pants/pixil-layer-3.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (pantsNum == '3') {
                                pantsNum = '';
                              } else {
                                pantsNum = '3';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/pants/pixil-layer-4.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (pantsNum == '4') {
                                pantsNum = '';
                              } else {
                                pantsNum = '4';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/pants/pixil-layer-5.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (pantsNum == '5') {
                                pantsNum = '';
                              } else {
                                pantsNum = '5';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                    ],
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                    children: [
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/pants/pixil-layer-6.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (pantsNum == '6') {
                                pantsNum = '';
                              } else {
                                pantsNum = '6';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/pants/pixil-layer-7.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (pantsNum == '7') {
                                pantsNum = '';
                              } else {
                                pantsNum = '7';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/pants/pixil-layer-8.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (pantsNum == '8') {
                                pantsNum = '';
                              } else {
                                pantsNum = '8';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/pants/pixil-layer-9.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (pantsNum == '9') {
                                pantsNum = '';
                              } else {
                                pantsNum = '9';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/pants/pixil-layer-10.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (pantsNum == '10') {
                                pantsNum = '';
                              } else {
                                pantsNum = '10';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                    ],
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                    children: [
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/pants/pixil-layer-11.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (pantsNum == '11') {
                                pantsNum = '';
                              } else {
                                pantsNum = '11';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/pants/pixil-layer-12.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (pantsNum == '12') {
                                pantsNum = '';
                              } else {
                                pantsNum = '12';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/pants/pixil-layer-13.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (pantsNum == '13') {
                                pantsNum = '';
                              } else {
                                pantsNum = '13';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/pants/pixil-layer-14.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (pantsNum == '14') {
                                pantsNum = '';
                              } else {
                                pantsNum = '14';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/pants/pixil-layer-15.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (pantsNum == '15') {
                                pantsNum = '';
                              } else {
                                pantsNum = '15';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                    ],
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                    children: [
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/pants/pixil-layer-16.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (pantsNum == '16') {
                                pantsNum = '';
                              } else {
                                pantsNum = '16';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/pants/pixil-layer-17.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (pantsNum == '17') {
                                pantsNum = '';
                              } else {
                                pantsNum = '17';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/pants/pixil-layer-18.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (pantsNum == '18') {
                                pantsNum = '';
                              } else {
                                pantsNum = '18';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/pants/pixil-layer-19.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (pantsNum == '19') {
                                pantsNum = '';
                              } else {
                                pantsNum = '19';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                      Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                'assets/images/pants/pixil-layer-20.png'),
                            fit: BoxFit.fill,
                          ),
                          border: Border.all(
                            color: Theme.of(context).secondaryHeaderColor,
                          ),
                          borderRadius: BorderRadius.circular(5),
                        ),
                        child: TextButton(
                          onPressed: () {
                            setState(() {
                              if (pantsNum == '20') {
                                pantsNum = '';
                              } else {
                                pantsNum = '20';
                              }
                            });
                          },
                          child: Container(),
                        ),
                      ),
                    ],
                  ),
                ],
              ),
            ),
            SizedBox(
              height: 10,
            ),
            SmoothPageIndicator(
              controller: _pantsController, // PageController
              count: 4,
              effect: JumpingDotEffect(
                activeDotColor: Theme.of(context).disabledColor,
                dotHeight: 5,
                dotWidth: 5,
              ),
            ),
            SizedBox(
              height: 10,
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                TextButton(
                  onPressed: mvPrev,
                  child: Container(
                    width: 140,
                    height: 40,
                    alignment: Alignment.center,
                    child: Text(
                      "이전",
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
                  onPressed: () {
                    signUp(
                        success: (dynamic response) async {
                          Navigator.pushNamed(context, "/login");
                        },
                        fail: (error) {
                          print('회원가입: $error');
                        },
                        body: _buildUserInfoBody(),
                    );
                  },
                  child: Container(
                    width: 140,
                    height: 40,
                    alignment: Alignment.center,
                    child: Text(
                      "완료",
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
    );
  }



  mvPrev() {
    Navigator.pop(context);
  }

  void _capture() async {
    // print("START CAPTURE");
    var renderObject = globalKey.currentContext!.findRenderObject();
    if (renderObject is RenderRepaintBoundary) {
      var boundary = renderObject;
      ui.Image image = await boundary.toImage();
      final directory = (await getApplicationDocumentsDirectory()).path;
      ByteData? byteData =
          await image.toByteData(format: ui.ImageByteFormat.png);
      Uint8List pngBytes = byteData!.buffer.asUint8List();
      // print(pngBytes);
      File imgFile = new File('$directory/screenshot.png');
      imgFile.writeAsBytes(pngBytes);
      print("FINISH CAPTURE ${imgFile.path}");
    } else {
      print("!");
    }
  }
}
