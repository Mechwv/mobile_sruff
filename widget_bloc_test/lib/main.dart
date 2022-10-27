import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';

import 'counter/counter_observer.dart';
import 'counter/view/counter_page.dart';

void main() {
  Bloc.observer = CounterObserver();
  runApp(const CounterPage());
}
