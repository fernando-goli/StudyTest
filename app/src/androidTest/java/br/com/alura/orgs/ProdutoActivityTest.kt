package br.com.alura.orgs

import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import br.com.alura.orgs.ui.activity.FormularioCadastroUsuarioActivity
import br.com.alura.orgs.ui.activity.FormularioProdutoActivity
import br.com.alura.orgs.ui.activity.ListaProdutosActivity
import br.com.alura.orgs.ui.activity.LoginActivity
import org.junit.Test

class ProdutoActivityTest {

    @Test
    fun deveMostrarNomeAplicativo(){
        launch(ListaProdutosActivity::class.java)
        onView(withText("Orgs"))
            .check(matches(isDisplayed()))
    }

    @Test
    fun deveMostrarCamposNecessarioParaCriarUmProduto() {
        launch(FormularioProdutoActivity::class.java)
        onView(withId(R.id.activity_formulario_produto_nome)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_formulario_produto_descricao)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_formulario_produto_valor)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_formulario_produto_botao_salvar)).check(matches(isDisplayed()))
    }

    @Test
    fun deveTerTodosOsCamposNecessariosFazerLogin() {
        launch(LoginActivity::class.java)
        onView(withId(R.id.activity_login_usuario)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_login_senha)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_login_botao_entrar)).check(matches(isDisplayed()))
    }

    @Test
    fun deveTerTodosOsCamposNecessariosFazerCadastro() {
        launch(FormularioCadastroUsuarioActivity::class.java)
        onView(withId(R.id.activity_formulario_cadastro_usuario)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_formulario_cadastro_email)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_formulario_cadastro_senha)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_formulario_cadastro_botao_cadastrar)).check(matches(isDisplayed()))
    }

    @Test
    fun deveSerCapazDePreencherCamposESalvar (){
        launch(FormularioProdutoActivity::class.java)
        onView(withId(R.id.activity_formulario_produto_nome)).perform(typeText("Uva"), closeSoftKeyboard())
        onView(withId(R.id.activity_formulario_produto_descricao)).perform(typeText("Thompson"), closeSoftKeyboard())
        onView(withId(R.id.activity_formulario_produto_valor)).perform(typeText("6.99"), closeSoftKeyboard())
        onView(withId(R.id.activity_formulario_produto_botao_salvar)).perform(click())

        launch(ListaProdutosActivity::class.java)
        onView(withText("Uva")).check(matches(isDisplayed()))
    }

}