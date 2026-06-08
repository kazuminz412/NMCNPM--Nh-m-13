@RestController
@RequestMapping("/api/thu-phi")
@RequiredArgsConstructor
public class ThuPhiController {

    private final ThuPhiService thuPhiService;

    @PostMapping("/xac-nhan")
    public ResponseEntity<?> xacNhan(@RequestBody ThuPhiRequest req) {
        thuPhiService.xacNhanThuTien(req.getHoaDonId(), req.getSoTien(), req.getPhuongThuc());
        return ResponseEntity.ok("Xác nhận thu tiền thành công!");
    }
}
