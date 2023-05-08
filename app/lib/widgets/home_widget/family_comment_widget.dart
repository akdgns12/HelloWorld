import 'package:flutter/material.dart';

class FamilyComment extends StatefulWidget {
  const FamilyComment({Key? key}) : super(key: key);

  @override
  State<FamilyComment> createState() => _FamilyCommentState();
}

class _FamilyCommentState extends State<FamilyComment> {
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
        child: Text("일촌평 부분"),
      ),
    );
  }
}
