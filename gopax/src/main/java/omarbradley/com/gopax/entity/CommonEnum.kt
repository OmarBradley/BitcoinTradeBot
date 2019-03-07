package omarbradley.com.gopax.entity

import omarbradley.com.gopax.entity.resopnse.Asset

enum class AssetType(
    val id: String,
    val korName: String
) {

    KRW("KRW", "대한민국 원"),
    ETH("ETH", "이더리움"),
    BTC("BTC", "비트코인"),
    BCH("BCH", "비트코인 캐시"),
    XLM("XLM", "스텔라 루멘"),
    ZEC("ZEC", "제트캐시"),
    LTC("LTC", "라이트코인"),
    ENG("ENG", "이니그마"),
    CVC("CVC", "시빅"),
    REQ("REQ", "리퀘스트 네트워크"),
    QASH("QASH", "캐시"),
    CND("CND", "신디케이터"),
    SNT("SNT", "스테이터스 네트워크"),
    ZRX("ZRX", "제로엑스"),
    EOS("EOS", "이오스"),
    OMG("OMG", "오미세고"),
    QTUM("QTUM", "퀀텀"),
    MOBI("MOBI", "모비우스"),
    STEEM("STEEM", "스팀"),
    SBD("SBD", "스팀달러"),
    ELF("ELF", "엘프"),
    XRP("XRP", "리플"),
    MKR("MKR", "메이커"),
    EOSDAC("EOSDAC", "이오스DAC"),
    ZIL("ZIL", "질리카"),
    LOOM("LOOM", "룸 네트워크"),
    MOC("MOC", "모스코인"),
    GNT("GNT", "골렘"),
    REP("REP", "어거"),
    KNC("KNC", "카이버 네트워크"),
    GNO("GNO", "노시스"),
    ANT("ANT", "아라곤"),
    QSP("QSP", "퀀트스탬프"),
    BAT("BAT", "베이직어텐션토큰"),
    IOST("IOST", "이오스트"),
    IQ("IQ", "에브리피디아"),
    HORUS("HORUS", "호루스페이"),
    BLACK("BLACK", "이오스블랙"),
    CHL("CHL", "챌린지닥"),
    ADD("ADD", "애더럴코인"),
    EOX("EOX", "이오엑스"),
    BSV("BSV", "비트코인 SV"),
    AERGO("AERGO", "아르고"),
    CRO("CRO", "크립토닷컴 체인"),
}

fun AssetType.toAsset() = Asset(this)

fun String.toAssetType() = AssetType.values()
    .first { it.id == this }

infix fun AssetType.toPair(quoteAssetType: AssetType): String = "$id-${quoteAssetType.id}"

/**
 * 주문 상태를 나타내는 Enum class
 */
enum class Status(
    val jsonString: String
) {
    /**
     * 주문됨
     */
    PLACED("placed"),

    /**
     * 취소됨
     */
    CANCELLED("cancelled"),

    /**
     * 체결됨
     */
    COMPLETED("completed"),

    /**
     * 부분 체결됨
     */
    UPDATED("updated")
}

fun String.toStatus() = Status.values()
    .first { it.jsonString == this }

/**
 * 주문 구분을 나타내는 Enum class
 */
enum class Side(
    val jsonString: String
) {
    /**
     * 구매
     */
    BUY("buy"),

    /**
     * 판매
     */
    SELL("sell")
}

fun String.toSide() = Side.values()
    .first { it.jsonString == this }

/**
 * 주문 종류을 나타내는 Enum class
 */
enum class Type(
    val jsonString: String
) {
    /**
     * 지정가
     */
    LIMIT("limit")
}

fun String.toType() = Type.values()
    .first { it.jsonString == this }
