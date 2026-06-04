@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {
    @Mock private NguoiDungRepository repository;
    @InjectMocks private AuthService authService;

    @Test
    void testLogin_Success() {
        NguoiDung user = new NguoiDung();
        user.setUsername("admin");
        user.setPassword("123456");
        
        when(repository.findByUsername("admin")).thenReturn(Optional.of(user));
        
        NguoiDung result = authService.login("admin", "123456");
        assertEquals("admin", result.getUsername());
    }
}
