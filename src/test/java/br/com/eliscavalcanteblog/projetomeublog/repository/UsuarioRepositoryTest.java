package br.com.eliscavalcanteblog.projetomeublog.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import br.com.eliscavalcanteblog.projetomeublog.Repository.UsuarioRepository;
import br.com.eliscavalcanteblog.projetomeublog.model.Usuario;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@BeforeAll
	void start() {
		usuarioRepository.deleteAll();
		
		usuarioRepository.save(new Usuario(0L, "Maria Elisabeth","elisabeth@123.com","12345678","https://br.freepik.com/fotos-vetores-gratis/imagem"));
		usuarioRepository.save(new Usuario(0L, "Maria Helena","helena@123.com","11111111","https://br.freepik.com/fotos-vetores-gratis/imagem"));
		usuarioRepository.save(new Usuario(0L, "Maria Julia","Julia@123.com","22222222","https://br.freepik.com/fotos-vetores-gratis/imagem"));
	}
	
	@Test
	@DisplayName("Retorna 1 usuário")
	public void deveRetornarUmUsuario() {
		Optional<Usuario> usuario = usuarioRepository.findByUsuario("elisabeth@123.com");
		assertTrue(usuario.get().getUsuario().equals("elisabeth@123.com"));
		
		
	}
	@Test
	@DisplayName("Retorna 3 usuários")
	public void deveRetornarTresUsuarios() {
		List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Maria");
		assertEquals(3,listaDeUsuarios.size());
		
		assertTrue(listaDeUsuarios.get(0).getNome().equals("Maria Helena"));
		assertTrue(listaDeUsuarios.get(0).getNome().equals("Maria Julia"));
		assertTrue(listaDeUsuarios.get(0).getNome().equals("Maria Elisabeth"));
	}
	
		@AfterAll
		public void end() {
			usuarioRepository.deleteAll();
		}
		

	}
