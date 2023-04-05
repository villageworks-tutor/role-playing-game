package rpg.character;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
