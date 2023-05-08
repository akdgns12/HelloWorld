import 'package:flutter/material.dart';
import 'package:app/services/home_api.dart';

class Grass extends StatefulWidget {
  const Grass({Key? key}) : super(key: key);

  @override
  State<Grass> createState() => _GrassState();
}

class _GrassState extends State<Grass> {
  dynamic grassInfo = [];

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    getGrass(success: (dynamic response) {
      setState(() {
        grassInfo = response['body'];
      });
    }, fail: (error) {
      print('잔디 내역 호출 오류: $error');
    });
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      margin: EdgeInsets.symmetric(
        vertical: 5,
        horizontal: 10,
      ),
      width: 1000,
      height: 145,
      decoration: BoxDecoration(
        border: Border.all(
          color: Theme.of(context).secondaryHeaderColor,
        ),
        borderRadius: BorderRadius.circular(10),
      ),
      child: Container(
        padding: EdgeInsets.all(
          10,
        ),
        child: Stack(
          children: [
            for (int i = 0; i < grassInfo.length; i++)
              grassInfo[i]!=null?
              Positioned(
                top: (i % 7) * 18 * 1.0,
                left: (i ~/ 7) * 20 * 1.0,
                child: Container(
                  width: 15,
                  height: 15,
                  decoration: BoxDecoration(
                    color: Theme.of(context).primaryColor.withOpacity(
                        grassInfo[i]['boardList'].length >= 4
                            ? 1.0
                            : grassInfo[i]['boardList'].length * 0.25),
                    border: Border.all(
                      color: Theme.of(context)
                          .secondaryHeaderColor
                          .withOpacity(0.6),
                    ),
                    borderRadius: BorderRadius.circular(
                      2.5,
                    ),
                  ),
                ),
              ):Positioned(
                top: (i % 7) * 18 * 1.0,
                left: (i ~/ 7) * 20 * 1.0,
                child: Container(
                  width: 15,
                  height: 15,
                  decoration: BoxDecoration(
                    color: Colors.white,
                    border: Border.all(
                      color: Theme.of(context)
                          .secondaryHeaderColor
                          .withOpacity(0.6),
                    ),
                    borderRadius: BorderRadius.circular(
                      2.5,
                    ),
                  ),
                ),
              ),
          ],
        ),
      ),
    );
  }
}
