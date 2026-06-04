@Service
@RequiredArgsConstructor
public class AuthService {
    private final NguoiDungRepository repository;
    private final BCryptPasswordEncoder passwordEncoder; // Inject Bean BCrypt vào

    public NguoiDung login(String username, String password) {
        return repository.findByUsername(username)
            .filter(user -> passwordEncoder.matches(password, user.getPassword())) 
            .orElseThrow(() -> new RuntimeException("Sai tên đăng nhập hoặc mật khẩu!"));
    }

    // Khi Đăng ký (Register), nhớ mã hóa trước khi lưu:
    public void register(NguoiDung user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
    }
}
