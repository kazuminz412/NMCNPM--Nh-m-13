@Service
@RequiredArgsConstructor
public class ChiTietHoaDonService {
    private final ChiTietHoaDonRepository repository;

    @Transactional
    public ChiTietHoaDon addPhiVaoHoaDon(ChiTietHoaDon chiTiet) {
        return repository.save(chiTiet);
    }
}
