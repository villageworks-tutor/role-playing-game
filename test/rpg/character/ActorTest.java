package rpg.character;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ActorTest {

	/** テスト対象クラス：system under test */
	Actor sut;
	
	@BeforeEach
	void setUp() throws Exception {
		String name = "勇者";
		int hp = 50;
		int attack = 10;
		sut = new Actor(name, hp, attack);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@ParameterizedTest
	@MethodSource("methodSource_attack")
	@DisplayName("Test-3：Actor#attack(Actor)メソッドのテスト")
	void testAttack(Actor target, String expected) {
		// execute
		sut.attack(target);
		// verify
		assertThat(target.toString(), is(expected));
	}
	static Stream<Arguments> methodSource_attack() {
		// setup
		List<Actor> targets = new ArrayList<>();
		List<String> expected = new ArrayList<>();
		
		// Test-31：「ゾンビ（HP：15）」が「ゾンビ（HP：5）」になる
		targets.add(new Actor("ゾンビ", 15, 5));
		expected.add("ゾンビ（HP：5）");

		// Test-32：「ゾンビ（HP：10）」が「ゾンビ（HP：0）」になる
		targets.add(new Actor("ゾンビ", 10, 5));
		expected.add("ゾンビ（HP：0）");
		
		// Test-32：「ゾンビ（HP：5）」が「ゾンビ（HP：0）」になる
		targets.add(new Actor("ゾンビ", 5, 5));
		expected.add("ゾンビ（HP：0）");
		
		return Stream.of(
					  // Test-31：「ゾンビ（HP：15）」が「ゾンビ（HP：5）」になる
					  Arguments.of(targets.get(0), expected.get(0))
					  // Test-31：「ゾンビ（HP：15）」が「ゾンビ（HP：5）」になる
					, Arguments.of(targets.get(1), expected.get(1))
					// Test-32：「ゾンビ（HP：5）」が「ゾンビ（HP：0）」になる
					, Arguments.of(targets.get(2), expected.get(2))
				);
	}
	
	@Test
	@DisplayName("Test-2：生成されたインスタンスの情報は「勇者（HP：50）」である")
	void testToString() {
		// setup
		String expected  = "勇者（HP：50）";
		// execute
		String actual = sut.toString();
		// verify
		assertThat(actual, is(expected));
	}
	
	@Test
	@DisplayName("Test-1：生成されたインスタンスはActorクラスのインスタンスである")
	void testConstructor() {
		assertThat(sut, is(instanceOf(Actor.class)));
	}

}
