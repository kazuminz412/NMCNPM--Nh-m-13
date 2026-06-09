@Service
@RequiredArgsConstructor
public class GiaoDichService {
    private final GiaoDichRepository repo;

    public GiaoDich luuGiaoDich(GiaoDich giaoDich) {
        return repo.save(giaoDich);
    }
}
