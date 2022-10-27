import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:widget_bloc_test/counter/bloc/counter_bloc.dart';
import 'package:widget_bloc_test/counter/bloc/counter_event.dart';
import 'package:widget_bloc_test/counter/bloc/counter_state.dart';


class CounterView extends StatefulWidget {
  const CounterView({Key? key}) : super(key: key);

  @override
  State<CounterView> createState() => _CounterViewState();
}

class _CounterViewState extends State<CounterView> {
  CounterBloc? bloc;

  @override
  void initState() {
    bloc = BlocProvider.of<CounterBloc>(context);
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    final textTheme = Theme.of(context).textTheme;

    return Scaffold(
      appBar: AppBar(title: const Text('Counter')),
      body: Center(
        child: BlocBuilder<CounterBloc, CounterState>(
          builder: (context, state) {
            if (state is CounterValue) {
              return Text('${state.counter}', style: textTheme.headline2);
            } else {
              return Text('LOADING', style: textTheme.headline2);
            }
          },
        ),
      ),
      floatingActionButton: Column(
        mainAxisAlignment: MainAxisAlignment.end,
        crossAxisAlignment: CrossAxisAlignment.end,
        children: <Widget>[
          FloatingActionButton(
            key: const Key('counterView_increment_floatingActionButton'),
            child: const Icon(Icons.add),
            onPressed: () => bloc?.add(IncrementEvent()),
          ),
          const SizedBox(height: 8),
          FloatingActionButton(
            key: const Key('counterView_decrement_floatingActionButton'),
            child: const Icon(Icons.remove),
            onPressed: () =>bloc?.add(DecrementEvent()),
          ),
        ],
      ),
    );
  }
}
