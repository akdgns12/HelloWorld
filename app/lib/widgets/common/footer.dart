import 'package:flutter/material.dart';

class Footer extends StatefulWidget {
  const Footer({Key? key}) : super(key: key);

  @override
  State<Footer> createState() => _FooterState();
}

class _FooterState extends State<Footer> {
  @override
  Widget build(BuildContext context) {
    return Container(
      height: 60,
      padding: const EdgeInsets.symmetric(horizontal: 8),
      decoration: BoxDecoration(
        border: Border(
          top: BorderSide(color: Colors.grey, width: 0.5),
        ),
        color: Colors.white,
      ),
      // color: Theme.of(context).primaryColorLight,
      child: Row(
        crossAxisAlignment: CrossAxisAlignment.center,
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: [
          TextButton(
            onPressed: () {
              if (ModalRoute.of(context)?.settings.name != '/home') {
                Navigator.pushNamed(context, '/home');
              }
            },
            child: Icon(
              ModalRoute.of(context)?.settings.name == '/home'
                  ? Icons.home
                  : Icons.home_outlined,
              color: ModalRoute.of(context)?.settings.name == '/home'
                  ? Theme.of(context).primaryColorLight
                  : Colors.grey,
              size: ModalRoute.of(context)?.settings.name == '/home' ? 40 : 30,
            ),
          ),
          TextButton(
            onPressed: () {
              if(ModalRoute.of(context)?.settings.name != '/community') {
                Navigator.pushNamed(context, '/community');
              }
            },
            child: Icon(
              ModalRoute.of(context)?.settings.name == '/community'?Icons.question_answer_rounded:Icons.question_answer,
              color: ModalRoute.of(context)?.settings.name == '/community'
                  ? Theme.of(context).primaryColorLight
                  : Colors.grey,
              size: ModalRoute.of(context)?.settings.name == '/community' ? 40 : 30,
            ),
          ),
          TextButton(
            onPressed: () {
              if (ModalRoute.of(context)?.settings.name != '/board') {
                Navigator.pushNamed(context, '/board');
              }
            },
            child: Icon(
              ModalRoute.of(context)?.settings.name == '/board'
                  ? Icons.developer_board_outlined
                  : Icons.developer_board,
              color: ModalRoute.of(context)?.settings.name == '/board'
                  ? Theme.of(context).primaryColorLight
                  : Colors.grey,
              size: ModalRoute.of(context)?.settings.name == '/board' ? 40 : 30,
            ),
          ),
          TextButton(
            onPressed: () {},
            child: Icon(
              Icons.note_alt_outlined,
              color: Colors.grey,
              size: 30,
            ),
          ),
          TextButton(
            onPressed: () {
              if (ModalRoute.of(context)?.settings.name != '/my-page') {
                Navigator.pushNamed(context, '/my-page');
              }
            },
            child: Icon(
              ModalRoute.of(context)?.settings.name == '/my-page'
                  ? Icons.account_circle
                  : Icons.account_circle_outlined,
              color: ModalRoute.of(context)?.settings.name == '/my-page'
                  ? Theme.of(context).primaryColorLight
                  : Colors.grey,
              size:
                  ModalRoute.of(context)?.settings.name == '/my-page' ? 40 : 30,
            ),
          ),
        ],
      ),
    );
  }
}
