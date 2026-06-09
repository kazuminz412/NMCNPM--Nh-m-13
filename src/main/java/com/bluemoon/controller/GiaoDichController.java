@RestController
@RequestMapping("/api/giao-dich")
@RequiredArgsConstructor
public class GiaoDichController {
    private final GiaoDichService service;

    @PostMapping
    public ResponseEntity<GiaoDich> create(@RequestBody GiaoDich gd) {
        return ResponseEntity.ok(service.luuGiaoDich(gd));
    }
}
