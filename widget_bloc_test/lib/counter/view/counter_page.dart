import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import '../bloc/counter_bloc.dart';
import 'counter_view.dart';

class CounterPage extends StatelessWidget {
  /// {@macro counter_page}
  const CounterPage({super.key});

  @override
  Widget build(BuildContext context) {
    return BlocProvider<CounterBloc>(
      create: (_) => CounterBloc(),
      child: const MaterialApp(
        debugShowCheckedModeBanner: false,
        home: CounterView(),
      ),
    );
  }
}