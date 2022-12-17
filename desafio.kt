// [Template no Kotlin Playground](https://pl.kotl.in/cDerDqPYP)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val id: Int, val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario): String {
        inscritos.add(usuario)
        return "Usuario ${usuario} matriculado com sucesso"
    }

    fun getInscrito(){
        for(inscrito in inscritos){
            println("Inscrito: ${inscrito.nome+" "+inscrito.id}")
        }
        for(conteudo in conteudos){
            println("${conteudo.nome}, ${conteudo.duracao}minutos e ${conteudo.nivel}")
        }
    }

    fun listaConteudosEducacional(){
        for(conteudo in conteudos){
            println("${conteudo.nome}, ${conteudo.duracao}minutos e ${conteudo.nivel}")
        }
    }

}

fun main() {
    //criando conteudos
    val cursoKotlinModuloOne = ConteudoEducacional("Introdução a Linguagem Kotlin", 80, Nivel.BASICO)
    val cursoKotlinModuloTwo = ConteudoEducacional("Hands One Kotlin", 120, Nivel.INTERMEDIARIO)
    val cursoKotlinModuloThree = ConteudoEducacional("Criando o Primeiro Programa em Kotlin", 180, Nivel.AVANCADO)
    val cursoJavaModuloOne = ConteudoEducacional("Introdução a Linguagem Java", 120, Nivel.BASICO)
    val cursoJavaModuloTwo = ConteudoEducacional("Hands One Java", 120, Nivel.INTERMEDIARIO)
    val cursoJavaModuloThree = ConteudoEducacional("Criando o Primeiro Programa em Java", 180, Nivel.AVANCADO)

    //criando lista de conteudos
    val listaConteudos = mutableListOf<ConteudoEducacional>()
    listaConteudos.add(cursoKotlinModuloOne)
    listaConteudos.add(cursoKotlinModuloTwo)
    listaConteudos.add(cursoKotlinModuloThree)
    listaConteudos.add(cursoJavaModuloOne)
    listaConteudos.add(cursoJavaModuloTwo)
    listaConteudos.add(cursoJavaModuloThree)


    //criando usuarios
    val usuarioOne = Usuario(1, "Débora")
    val usuarioTwo = Usuario(2, "Silva")

    //criando Bootcamp
    val linguagemProgramacao = Formacao("Bootcamp Java e Kotlin", listaConteudos)

    //inserindo usuarios
    linguagemProgramacao.matricular(usuarioOne)
    linguagemProgramacao.matricular(usuarioTwo)

    println("${linguagemProgramacao.nome}")
    println(" ---------------------------------------------- ")

    println("Cursos contidos no Bootcamp")
    println(linguagemProgramacao.listaConteudosEducacional())
    println(" ---------------------------------------------- ")

    println("Inscritos")
    println(linguagemProgramacao.getInscrito())
}