import 'package:flutter/material.dart';
import 'package:app/widgets/common/footer.dart';
import 'package:app/widgets/common/header.dart';
import 'package:app/widgets/home_widget/grass_widget.dart';
import 'package:app/widgets/home_widget/room_widget.dart';
import 'package:flutter/services.dart';

class Home extends StatefulWidget {
  const Home({Key? key}) : super(key: key);

  @override
  State<Home> createState() => _HomeState();
}

class _HomeState extends State<Home> {

  @override
  Widget build(BuildContext context) {
    // SystemChrome.setEnabledSystemUIMode(SystemUiMode.manual, overlays: [SystemUiOverlay.bottom]);
    return Container(
      color: Colors.white,
      child: Column(
        children: [
          Header(),
          Expanded(
            child: Column(
              children: [
                // 방
                MyRoom(),
                // 잔디
                Grass(),

              ],
            ),
          ),
          Footer(),
        ],
      ),
    );
  }
}
