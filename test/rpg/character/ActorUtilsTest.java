package rpg.character;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ActorUtilsTest {

	@ParameterizedTest
	@MethodSource("methodSource")
	@DisplayName("Test-1：1～3に対応する敵を生成するメソッドのテスト")
	void testRandomEnemy(int weight, Actor expected) {
		// execute
		Actor actual = Actor.randomEnemyBy(weight);
		// verify
		assertThat(actual, is(instanceOf(expected.getClass())));
		assertThat(actual.toString(), is(expected.toString()));
		assertThat(actual.getAttack(), is(expected.getAttack()));
	}
	static Stream<Arguments> methodSource() {
		// setup
		List<Integer> inputs = new ArrayList<>();
		List<Actor> enemies = new ArrayList<>();
		
		// Test-11：「1」を入力すると「ゾンビ HP：10 攻撃力：5」が返される
		inputs.add(1);
		enemies.add(new Zombie(10, 5));
		// Test-12：「2」を入力すると「ゾンビ HP：20 攻撃力：10」が返される
		inputs.add(2);
		enemies.add(new Zombie(20, 10));
		// Test-12：「3」を入力すると「ゴースト HP：30 攻撃力：15」が返される
		inputs.add(3);
		enemies.add(new Ghost(30, 15));
		
		return Stream.of(
					  // Test-11：「1」を入力すると「ゾンビ HP：10 攻撃力：5」が返される
					  Arguments.of(inputs.get(0), enemies.get(0))
					  // Test-12：「2」を入力すると「ゾンビ HP：20 攻撃力：10」が返される
					, Arguments.of(inputs.get(1), enemies.get(1))
					  // Test-12：「3」を入力すると「ゴースト HP：30 攻撃力：15」が返される
					, Arguments.of(inputs.get(2), enemies.get(2))
				);
	}

}
