@RestController
@RequestMapping("/api/chi-tiet-hoa-don")
@RequiredArgsConstructor
public class ChiTietHoaDonController {

    private final ChiTietHoaDonService service;

    @PostMapping
    public ResponseEntity<ChiTietHoaDon> addPhi(@RequestBody ChiTietHoaDon chiTiet) {
        return ResponseEntity.ok(service.addPhiVaoHoaDon(chiTiet));
    }
}
