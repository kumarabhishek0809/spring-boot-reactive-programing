import com.async.rest.model.CountryDTO;
import com.async.rest.model.CountryRestResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

public class RestResponseTest {

    private final static String RESPONSE = "{\n" +
            "  \"RestResponse\" : {\n" +
            "    \"messages\" : [ \"Total [249] records found.\" ],\n" +
            "    \"result\" : [ {\n" +
            "      \"name\" : \"Afghanistan\",\n" +
            "      \"alpha2_code\" : \"AF\",\n" +
            "      \"alpha3_code\" : \"AFG\"\n" +
            "    }, {\n" +
            "      \"name\" : \"��land Islands\",\n" +
            "      \"alpha2_code\" : \"AX\",\n" +
            "      \"alpha3_code\" : \"ALA\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Albania\",\n" +
            "      \"alpha2_code\" : \"AL\",\n" +
            "      \"alpha3_code\" : \"ALB\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Algeria\",\n" +
            "      \"alpha2_code\" : \"DZ\",\n" +
            "      \"alpha3_code\" : \"DZA\"\n" +
            "    }, {\n" +
            "      \"name\" : \"American Samoa\",\n" +
            "      \"alpha2_code\" : \"AS\",\n" +
            "      \"alpha3_code\" : \"ASM\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Andorra\",\n" +
            "      \"alpha2_code\" : \"AD\",\n" +
            "      \"alpha3_code\" : \"AND\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Angola\",\n" +
            "      \"alpha2_code\" : \"AO\",\n" +
            "      \"alpha3_code\" : \"AGO\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Anguilla\",\n" +
            "      \"alpha2_code\" : \"AI\",\n" +
            "      \"alpha3_code\" : \"AIA\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Antarctica\",\n" +
            "      \"alpha2_code\" : \"AQ\",\n" +
            "      \"alpha3_code\" : \"ATA\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Antigua and Barbuda\",\n" +
            "      \"alpha2_code\" : \"AG\",\n" +
            "      \"alpha3_code\" : \"ATG\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Argentina\",\n" +
            "      \"alpha2_code\" : \"AR\",\n" +
            "      \"alpha3_code\" : \"ARG\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Armenia\",\n" +
            "      \"alpha2_code\" : \"AM\",\n" +
            "      \"alpha3_code\" : \"ARM\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Aruba\",\n" +
            "      \"alpha2_code\" : \"AW\",\n" +
            "      \"alpha3_code\" : \"ABW\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Australia\",\n" +
            "      \"alpha2_code\" : \"AU\",\n" +
            "      \"alpha3_code\" : \"AUS\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Austria\",\n" +
            "      \"alpha2_code\" : \"AT\",\n" +
            "      \"alpha3_code\" : \"AUT\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Azerbaijan\",\n" +
            "      \"alpha2_code\" : \"AZ\",\n" +
            "      \"alpha3_code\" : \"AZE\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Bahamas\",\n" +
            "      \"alpha2_code\" : \"BS\",\n" +
            "      \"alpha3_code\" : \"BHS\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Bahrain\",\n" +
            "      \"alpha2_code\" : \"BH\",\n" +
            "      \"alpha3_code\" : \"BHR\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Bangladesh\",\n" +
            "      \"alpha2_code\" : \"BD\",\n" +
            "      \"alpha3_code\" : \"BGD\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Barbados\",\n" +
            "      \"alpha2_code\" : \"BB\",\n" +
            "      \"alpha3_code\" : \"BRB\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Belarus\",\n" +
            "      \"alpha2_code\" : \"BY\",\n" +
            "      \"alpha3_code\" : \"BLR\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Belgium\",\n" +
            "      \"alpha2_code\" : \"BE\",\n" +
            "      \"alpha3_code\" : \"BEL\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Belize\",\n" +
            "      \"alpha2_code\" : \"BZ\",\n" +
            "      \"alpha3_code\" : \"BLZ\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Benin\",\n" +
            "      \"alpha2_code\" : \"BJ\",\n" +
            "      \"alpha3_code\" : \"BEN\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Bermuda\",\n" +
            "      \"alpha2_code\" : \"BM\",\n" +
            "      \"alpha3_code\" : \"BMU\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Bhutan\",\n" +
            "      \"alpha2_code\" : \"BT\",\n" +
            "      \"alpha3_code\" : \"BTN\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Bolivia (Plurinational State of)\",\n" +
            "      \"alpha2_code\" : \"BO\",\n" +
            "      \"alpha3_code\" : \"BOL\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Bonaire, Sint Eustatius and Saba\",\n" +
            "      \"alpha2_code\" : \"BQ\",\n" +
            "      \"alpha3_code\" : \"BES\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Bosnia and Herzegovina\",\n" +
            "      \"alpha2_code\" : \"BA\",\n" +
            "      \"alpha3_code\" : \"BIH\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Botswana\",\n" +
            "      \"alpha2_code\" : \"BW\",\n" +
            "      \"alpha3_code\" : \"BWA\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Bouvet Island\",\n" +
            "      \"alpha2_code\" : \"BV\",\n" +
            "      \"alpha3_code\" : \"BVT\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Brazil\",\n" +
            "      \"alpha2_code\" : \"BR\",\n" +
            "      \"alpha3_code\" : \"BRA\"\n" +
            "    }, {\n" +
            "      \"name\" : \"British Indian Ocean Territory\",\n" +
            "      \"alpha2_code\" : \"IO\",\n" +
            "      \"alpha3_code\" : \"IOT\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Brunei Darussalam\",\n" +
            "      \"alpha2_code\" : \"BN\",\n" +
            "      \"alpha3_code\" : \"BRN\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Bulgaria\",\n" +
            "      \"alpha2_code\" : \"BG\",\n" +
            "      \"alpha3_code\" : \"BGR\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Burkina Faso\",\n" +
            "      \"alpha2_code\" : \"BF\",\n" +
            "      \"alpha3_code\" : \"BFA\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Burundi\",\n" +
            "      \"alpha2_code\" : \"BI\",\n" +
            "      \"alpha3_code\" : \"BDI\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Cabo Verde\",\n" +
            "      \"alpha2_code\" : \"CV\",\n" +
            "      \"alpha3_code\" : \"CPV\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Cambodia\",\n" +
            "      \"alpha2_code\" : \"KH\",\n" +
            "      \"alpha3_code\" : \"KHM\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Cameroon\",\n" +
            "      \"alpha2_code\" : \"CM\",\n" +
            "      \"alpha3_code\" : \"CMR\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Canada\",\n" +
            "      \"alpha2_code\" : \"CA\",\n" +
            "      \"alpha3_code\" : \"CAN\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Cayman Islands\",\n" +
            "      \"alpha2_code\" : \"KY\",\n" +
            "      \"alpha3_code\" : \"CYM\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Central African Republic\",\n" +
            "      \"alpha2_code\" : \"CF\",\n" +
            "      \"alpha3_code\" : \"CAF\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Chad\",\n" +
            "      \"alpha2_code\" : \"TD\",\n" +
            "      \"alpha3_code\" : \"TCD\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Chile\",\n" +
            "      \"alpha2_code\" : \"CL\",\n" +
            "      \"alpha3_code\" : \"CHL\"\n" +
            "    }, {\n" +
            "      \"name\" : \"China\",\n" +
            "      \"alpha2_code\" : \"CN\",\n" +
            "      \"alpha3_code\" : \"CHN\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Christmas Island\",\n" +
            "      \"alpha2_code\" : \"CX\",\n" +
            "      \"alpha3_code\" : \"CXR\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Cocos (Keeling) Islands\",\n" +
            "      \"alpha2_code\" : \"CC\",\n" +
            "      \"alpha3_code\" : \"CCK\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Colombia\",\n" +
            "      \"alpha2_code\" : \"CO\",\n" +
            "      \"alpha3_code\" : \"COL\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Comoros\",\n" +
            "      \"alpha2_code\" : \"KM\",\n" +
            "      \"alpha3_code\" : \"COM\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Congo\",\n" +
            "      \"alpha2_code\" : \"CG\",\n" +
            "      \"alpha3_code\" : \"COG\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Congo (Democratic Republic of the)\",\n" +
            "      \"alpha2_code\" : \"CD\",\n" +
            "      \"alpha3_code\" : \"COD\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Cook Islands\",\n" +
            "      \"alpha2_code\" : \"CK\",\n" +
            "      \"alpha3_code\" : \"COK\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Costa Rica\",\n" +
            "      \"alpha2_code\" : \"CR\",\n" +
            "      \"alpha3_code\" : \"CRI\"\n" +
            "    }, {\n" +
            "      \"name\" : \"C��te d'Ivoire\",\n" +
            "      \"alpha2_code\" : \"CI\",\n" +
            "      \"alpha3_code\" : \"CIV\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Croatia\",\n" +
            "      \"alpha2_code\" : \"HR\",\n" +
            "      \"alpha3_code\" : \"HRV\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Cuba\",\n" +
            "      \"alpha2_code\" : \"CU\",\n" +
            "      \"alpha3_code\" : \"CUB\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Cura��ao\",\n" +
            "      \"alpha2_code\" : \"CW\",\n" +
            "      \"alpha3_code\" : \"CUW\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Cyprus\",\n" +
            "      \"alpha2_code\" : \"CY\",\n" +
            "      \"alpha3_code\" : \"CYP\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Czechia\",\n" +
            "      \"alpha2_code\" : \"CZ\",\n" +
            "      \"alpha3_code\" : \"CZE\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Denmark\",\n" +
            "      \"alpha2_code\" : \"DK\",\n" +
            "      \"alpha3_code\" : \"DNK\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Djibouti\",\n" +
            "      \"alpha2_code\" : \"DJ\",\n" +
            "      \"alpha3_code\" : \"DJI\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Dominica\",\n" +
            "      \"alpha2_code\" : \"DM\",\n" +
            "      \"alpha3_code\" : \"DMA\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Dominican Republic\",\n" +
            "      \"alpha2_code\" : \"DO\",\n" +
            "      \"alpha3_code\" : \"DOM\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Ecuador\",\n" +
            "      \"alpha2_code\" : \"EC\",\n" +
            "      \"alpha3_code\" : \"ECU\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Egypt\",\n" +
            "      \"alpha2_code\" : \"EG\",\n" +
            "      \"alpha3_code\" : \"EGY\"\n" +
            "    }, {\n" +
            "      \"name\" : \"El Salvador\",\n" +
            "      \"alpha2_code\" : \"SV\",\n" +
            "      \"alpha3_code\" : \"SLV\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Equatorial Guinea\",\n" +
            "      \"alpha2_code\" : \"GQ\",\n" +
            "      \"alpha3_code\" : \"GNQ\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Eritrea\",\n" +
            "      \"alpha2_code\" : \"ER\",\n" +
            "      \"alpha3_code\" : \"ERI\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Estonia\",\n" +
            "      \"alpha2_code\" : \"EE\",\n" +
            "      \"alpha3_code\" : \"EST\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Ethiopia\",\n" +
            "      \"alpha2_code\" : \"ET\",\n" +
            "      \"alpha3_code\" : \"ETH\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Falkland Islands (Malvinas)\",\n" +
            "      \"alpha2_code\" : \"FK\",\n" +
            "      \"alpha3_code\" : \"FLK\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Faroe Islands\",\n" +
            "      \"alpha2_code\" : \"FO\",\n" +
            "      \"alpha3_code\" : \"FRO\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Fiji\",\n" +
            "      \"alpha2_code\" : \"FJ\",\n" +
            "      \"alpha3_code\" : \"FJI\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Finland\",\n" +
            "      \"alpha2_code\" : \"FI\",\n" +
            "      \"alpha3_code\" : \"FIN\"\n" +
            "    }, {\n" +
            "      \"name\" : \"France\",\n" +
            "      \"alpha2_code\" : \"FR\",\n" +
            "      \"alpha3_code\" : \"FRA\"\n" +
            "    }, {\n" +
            "      \"name\" : \"French Guiana\",\n" +
            "      \"alpha2_code\" : \"GF\",\n" +
            "      \"alpha3_code\" : \"GUF\"\n" +
            "    }, {\n" +
            "      \"name\" : \"French Polynesia\",\n" +
            "      \"alpha2_code\" : \"PF\",\n" +
            "      \"alpha3_code\" : \"PYF\"\n" +
            "    }, {\n" +
            "      \"name\" : \"French Southern Territories\",\n" +
            "      \"alpha2_code\" : \"TF\",\n" +
            "      \"alpha3_code\" : \"ATF\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Gabon\",\n" +
            "      \"alpha2_code\" : \"GA\",\n" +
            "      \"alpha3_code\" : \"GAB\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Gambia\",\n" +
            "      \"alpha2_code\" : \"GM\",\n" +
            "      \"alpha3_code\" : \"GMB\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Georgia\",\n" +
            "      \"alpha2_code\" : \"GE\",\n" +
            "      \"alpha3_code\" : \"GEO\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Germany\",\n" +
            "      \"alpha2_code\" : \"DE\",\n" +
            "      \"alpha3_code\" : \"DEU\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Ghana\",\n" +
            "      \"alpha2_code\" : \"GH\",\n" +
            "      \"alpha3_code\" : \"GHA\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Gibraltar\",\n" +
            "      \"alpha2_code\" : \"GI\",\n" +
            "      \"alpha3_code\" : \"GIB\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Greece\",\n" +
            "      \"alpha2_code\" : \"GR\",\n" +
            "      \"alpha3_code\" : \"GRC\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Greenland\",\n" +
            "      \"alpha2_code\" : \"GL\",\n" +
            "      \"alpha3_code\" : \"GRL\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Grenada\",\n" +
            "      \"alpha2_code\" : \"GD\",\n" +
            "      \"alpha3_code\" : \"GRD\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Guadeloupe\",\n" +
            "      \"alpha2_code\" : \"GP\",\n" +
            "      \"alpha3_code\" : \"GLP\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Guam\",\n" +
            "      \"alpha2_code\" : \"GU\",\n" +
            "      \"alpha3_code\" : \"GUM\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Guatemala\",\n" +
            "      \"alpha2_code\" : \"GT\",\n" +
            "      \"alpha3_code\" : \"GTM\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Guernsey\",\n" +
            "      \"alpha2_code\" : \"GG\",\n" +
            "      \"alpha3_code\" : \"GGY\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Guinea\",\n" +
            "      \"alpha2_code\" : \"GN\",\n" +
            "      \"alpha3_code\" : \"GIN\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Guinea-Bissau\",\n" +
            "      \"alpha2_code\" : \"GW\",\n" +
            "      \"alpha3_code\" : \"GNB\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Guyana\",\n" +
            "      \"alpha2_code\" : \"GY\",\n" +
            "      \"alpha3_code\" : \"GUY\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Haiti\",\n" +
            "      \"alpha2_code\" : \"HT\",\n" +
            "      \"alpha3_code\" : \"HTI\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Heard Island and McDonald Islands\",\n" +
            "      \"alpha2_code\" : \"HM\",\n" +
            "      \"alpha3_code\" : \"HMD\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Holy See\",\n" +
            "      \"alpha2_code\" : \"VA\",\n" +
            "      \"alpha3_code\" : \"VAT\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Honduras\",\n" +
            "      \"alpha2_code\" : \"HN\",\n" +
            "      \"alpha3_code\" : \"HND\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Hong Kong\",\n" +
            "      \"alpha2_code\" : \"HK\",\n" +
            "      \"alpha3_code\" : \"HKG\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Hungary\",\n" +
            "      \"alpha2_code\" : \"HU\",\n" +
            "      \"alpha3_code\" : \"HUN\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Iceland\",\n" +
            "      \"alpha2_code\" : \"IS\",\n" +
            "      \"alpha3_code\" : \"ISL\"\n" +
            "    }, {\n" +
            "      \"name\" : \"India\",\n" +
            "      \"alpha2_code\" : \"IN\",\n" +
            "      \"alpha3_code\" : \"IND\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Indonesia\",\n" +
            "      \"alpha2_code\" : \"ID\",\n" +
            "      \"alpha3_code\" : \"IDN\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Iran (Islamic Republic of)\",\n" +
            "      \"alpha2_code\" : \"IR\",\n" +
            "      \"alpha3_code\" : \"IRN\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Iraq\",\n" +
            "      \"alpha2_code\" : \"IQ\",\n" +
            "      \"alpha3_code\" : \"IRQ\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Ireland\",\n" +
            "      \"alpha2_code\" : \"IE\",\n" +
            "      \"alpha3_code\" : \"IRL\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Isle of Man\",\n" +
            "      \"alpha2_code\" : \"IM\",\n" +
            "      \"alpha3_code\" : \"IMN\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Israel\",\n" +
            "      \"alpha2_code\" : \"IL\",\n" +
            "      \"alpha3_code\" : \"ISR\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Italy\",\n" +
            "      \"alpha2_code\" : \"IT\",\n" +
            "      \"alpha3_code\" : \"ITA\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Jamaica\",\n" +
            "      \"alpha2_code\" : \"JM\",\n" +
            "      \"alpha3_code\" : \"JAM\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Japan\",\n" +
            "      \"alpha2_code\" : \"JP\",\n" +
            "      \"alpha3_code\" : \"JPN\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Jersey\",\n" +
            "      \"alpha2_code\" : \"JE\",\n" +
            "      \"alpha3_code\" : \"JEY\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Jordan\",\n" +
            "      \"alpha2_code\" : \"JO\",\n" +
            "      \"alpha3_code\" : \"JOR\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Kazakhstan\",\n" +
            "      \"alpha2_code\" : \"KZ\",\n" +
            "      \"alpha3_code\" : \"KAZ\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Kenya\",\n" +
            "      \"alpha2_code\" : \"KE\",\n" +
            "      \"alpha3_code\" : \"KEN\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Kiribati\",\n" +
            "      \"alpha2_code\" : \"KI\",\n" +
            "      \"alpha3_code\" : \"KIR\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Korea (Democratic People's Republic of)\",\n" +
            "      \"alpha2_code\" : \"KP\",\n" +
            "      \"alpha3_code\" : \"PRK\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Korea (Republic of)\",\n" +
            "      \"alpha2_code\" : \"KR\",\n" +
            "      \"alpha3_code\" : \"KOR\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Kuwait\",\n" +
            "      \"alpha2_code\" : \"KW\",\n" +
            "      \"alpha3_code\" : \"KWT\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Kyrgyzstan\",\n" +
            "      \"alpha2_code\" : \"KG\",\n" +
            "      \"alpha3_code\" : \"KGZ\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Lao People's Democratic Republic\",\n" +
            "      \"alpha2_code\" : \"LA\",\n" +
            "      \"alpha3_code\" : \"LAO\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Latvia\",\n" +
            "      \"alpha2_code\" : \"LV\",\n" +
            "      \"alpha3_code\" : \"LVA\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Lebanon\",\n" +
            "      \"alpha2_code\" : \"LB\",\n" +
            "      \"alpha3_code\" : \"LBN\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Lesotho\",\n" +
            "      \"alpha2_code\" : \"LS\",\n" +
            "      \"alpha3_code\" : \"LSO\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Liberia\",\n" +
            "      \"alpha2_code\" : \"LR\",\n" +
            "      \"alpha3_code\" : \"LBR\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Libya\",\n" +
            "      \"alpha2_code\" : \"LY\",\n" +
            "      \"alpha3_code\" : \"LBY\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Liechtenstein\",\n" +
            "      \"alpha2_code\" : \"LI\",\n" +
            "      \"alpha3_code\" : \"LIE\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Lithuania\",\n" +
            "      \"alpha2_code\" : \"LT\",\n" +
            "      \"alpha3_code\" : \"LTU\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Luxembourg\",\n" +
            "      \"alpha2_code\" : \"LU\",\n" +
            "      \"alpha3_code\" : \"LUX\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Macao\",\n" +
            "      \"alpha2_code\" : \"MO\",\n" +
            "      \"alpha3_code\" : \"MAC\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Macedonia (the former Yugoslav Republic of)\",\n" +
            "      \"alpha2_code\" : \"MK\",\n" +
            "      \"alpha3_code\" : \"MKD\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Madagascar\",\n" +
            "      \"alpha2_code\" : \"MG\",\n" +
            "      \"alpha3_code\" : \"MDG\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Malawi\",\n" +
            "      \"alpha2_code\" : \"MW\",\n" +
            "      \"alpha3_code\" : \"MWI\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Malaysia\",\n" +
            "      \"alpha2_code\" : \"MY\",\n" +
            "      \"alpha3_code\" : \"MYS\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Maldives\",\n" +
            "      \"alpha2_code\" : \"MV\",\n" +
            "      \"alpha3_code\" : \"MDV\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Mali\",\n" +
            "      \"alpha2_code\" : \"ML\",\n" +
            "      \"alpha3_code\" : \"MLI\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Malta\",\n" +
            "      \"alpha2_code\" : \"MT\",\n" +
            "      \"alpha3_code\" : \"MLT\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Marshall Islands\",\n" +
            "      \"alpha2_code\" : \"MH\",\n" +
            "      \"alpha3_code\" : \"MHL\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Martinique\",\n" +
            "      \"alpha2_code\" : \"MQ\",\n" +
            "      \"alpha3_code\" : \"MTQ\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Mauritania\",\n" +
            "      \"alpha2_code\" : \"MR\",\n" +
            "      \"alpha3_code\" : \"MRT\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Mauritius\",\n" +
            "      \"alpha2_code\" : \"MU\",\n" +
            "      \"alpha3_code\" : \"MUS\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Mayotte\",\n" +
            "      \"alpha2_code\" : \"YT\",\n" +
            "      \"alpha3_code\" : \"MYT\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Mexico\",\n" +
            "      \"alpha2_code\" : \"MX\",\n" +
            "      \"alpha3_code\" : \"MEX\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Micronesia (Federated States of)\",\n" +
            "      \"alpha2_code\" : \"FM\",\n" +
            "      \"alpha3_code\" : \"FSM\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Moldova (Republic of)\",\n" +
            "      \"alpha2_code\" : \"MD\",\n" +
            "      \"alpha3_code\" : \"MDA\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Monaco\",\n" +
            "      \"alpha2_code\" : \"MC\",\n" +
            "      \"alpha3_code\" : \"MCO\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Mongolia\",\n" +
            "      \"alpha2_code\" : \"MN\",\n" +
            "      \"alpha3_code\" : \"MNG\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Montenegro\",\n" +
            "      \"alpha2_code\" : \"ME\",\n" +
            "      \"alpha3_code\" : \"MNE\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Montserrat\",\n" +
            "      \"alpha2_code\" : \"MS\",\n" +
            "      \"alpha3_code\" : \"MSR\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Morocco\",\n" +
            "      \"alpha2_code\" : \"MA\",\n" +
            "      \"alpha3_code\" : \"MAR\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Mozambique\",\n" +
            "      \"alpha2_code\" : \"MZ\",\n" +
            "      \"alpha3_code\" : \"MOZ\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Myanmar\",\n" +
            "      \"alpha2_code\" : \"MM\",\n" +
            "      \"alpha3_code\" : \"MMR\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Namibia\",\n" +
            "      \"alpha2_code\" : \"NA\",\n" +
            "      \"alpha3_code\" : \"NAM\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Nauru\",\n" +
            "      \"alpha2_code\" : \"NR\",\n" +
            "      \"alpha3_code\" : \"NRU\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Nepal\",\n" +
            "      \"alpha2_code\" : \"NP\",\n" +
            "      \"alpha3_code\" : \"NPL\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Netherlands\",\n" +
            "      \"alpha2_code\" : \"NL\",\n" +
            "      \"alpha3_code\" : \"NLD\"\n" +
            "    }, {\n" +
            "      \"name\" : \"New Caledonia\",\n" +
            "      \"alpha2_code\" : \"NC\",\n" +
            "      \"alpha3_code\" : \"NCL\"\n" +
            "    }, {\n" +
            "      \"name\" : \"New Zealand\",\n" +
            "      \"alpha2_code\" : \"NZ\",\n" +
            "      \"alpha3_code\" : \"NZL\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Nicaragua\",\n" +
            "      \"alpha2_code\" : \"NI\",\n" +
            "      \"alpha3_code\" : \"NIC\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Niger\",\n" +
            "      \"alpha2_code\" : \"NE\",\n" +
            "      \"alpha3_code\" : \"NER\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Nigeria\",\n" +
            "      \"alpha2_code\" : \"NG\",\n" +
            "      \"alpha3_code\" : \"NGA\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Niue\",\n" +
            "      \"alpha2_code\" : \"NU\",\n" +
            "      \"alpha3_code\" : \"NIU\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Norfolk Island\",\n" +
            "      \"alpha2_code\" : \"NF\",\n" +
            "      \"alpha3_code\" : \"NFK\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Northern Mariana Islands\",\n" +
            "      \"alpha2_code\" : \"MP\",\n" +
            "      \"alpha3_code\" : \"MNP\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Norway\",\n" +
            "      \"alpha2_code\" : \"NO\",\n" +
            "      \"alpha3_code\" : \"NOR\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Oman\",\n" +
            "      \"alpha2_code\" : \"OM\",\n" +
            "      \"alpha3_code\" : \"OMN\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Pakistan\",\n" +
            "      \"alpha2_code\" : \"PK\",\n" +
            "      \"alpha3_code\" : \"PAK\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Palau\",\n" +
            "      \"alpha2_code\" : \"PW\",\n" +
            "      \"alpha3_code\" : \"PLW\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Palestine, State of\",\n" +
            "      \"alpha2_code\" : \"PS\",\n" +
            "      \"alpha3_code\" : \"PSE\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Panama\",\n" +
            "      \"alpha2_code\" : \"PA\",\n" +
            "      \"alpha3_code\" : \"PAN\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Papua New Guinea\",\n" +
            "      \"alpha2_code\" : \"PG\",\n" +
            "      \"alpha3_code\" : \"PNG\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Paraguay\",\n" +
            "      \"alpha2_code\" : \"PY\",\n" +
            "      \"alpha3_code\" : \"PRY\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Peru\",\n" +
            "      \"alpha2_code\" : \"PE\",\n" +
            "      \"alpha3_code\" : \"PER\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Philippines\",\n" +
            "      \"alpha2_code\" : \"PH\",\n" +
            "      \"alpha3_code\" : \"PHL\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Pitcairn\",\n" +
            "      \"alpha2_code\" : \"PN\",\n" +
            "      \"alpha3_code\" : \"PCN\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Poland\",\n" +
            "      \"alpha2_code\" : \"PL\",\n" +
            "      \"alpha3_code\" : \"POL\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Portugal\",\n" +
            "      \"alpha2_code\" : \"PT\",\n" +
            "      \"alpha3_code\" : \"PRT\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Puerto Rico\",\n" +
            "      \"alpha2_code\" : \"PR\",\n" +
            "      \"alpha3_code\" : \"PRI\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Qatar\",\n" +
            "      \"alpha2_code\" : \"QA\",\n" +
            "      \"alpha3_code\" : \"QAT\"\n" +
            "    }, {\n" +
            "      \"name\" : \"R��union\",\n" +
            "      \"alpha2_code\" : \"RE\",\n" +
            "      \"alpha3_code\" : \"REU\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Romania\",\n" +
            "      \"alpha2_code\" : \"RO\",\n" +
            "      \"alpha3_code\" : \"ROU\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Russian Federation\",\n" +
            "      \"alpha2_code\" : \"RU\",\n" +
            "      \"alpha3_code\" : \"RUS\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Rwanda\",\n" +
            "      \"alpha2_code\" : \"RW\",\n" +
            "      \"alpha3_code\" : \"RWA\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Saint Barth��lemy\",\n" +
            "      \"alpha2_code\" : \"BL\",\n" +
            "      \"alpha3_code\" : \"BLM\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Saint Helena, Ascension and Tristan da Cunha\",\n" +
            "      \"alpha2_code\" : \"SH\",\n" +
            "      \"alpha3_code\" : \"SHN\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Saint Kitts and Nevis\",\n" +
            "      \"alpha2_code\" : \"KN\",\n" +
            "      \"alpha3_code\" : \"KNA\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Saint Lucia\",\n" +
            "      \"alpha2_code\" : \"LC\",\n" +
            "      \"alpha3_code\" : \"LCA\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Saint Martin (French part)\",\n" +
            "      \"alpha2_code\" : \"MF\",\n" +
            "      \"alpha3_code\" : \"MAF\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Saint Pierre and Miquelon\",\n" +
            "      \"alpha2_code\" : \"PM\",\n" +
            "      \"alpha3_code\" : \"SPM\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Saint Vincent and the Grenadines\",\n" +
            "      \"alpha2_code\" : \"VC\",\n" +
            "      \"alpha3_code\" : \"VCT\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Samoa\",\n" +
            "      \"alpha2_code\" : \"WS\",\n" +
            "      \"alpha3_code\" : \"WSM\"\n" +
            "    }, {\n" +
            "      \"name\" : \"San Marino\",\n" +
            "      \"alpha2_code\" : \"SM\",\n" +
            "      \"alpha3_code\" : \"SMR\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Sao Tome and Principe\",\n" +
            "      \"alpha2_code\" : \"ST\",\n" +
            "      \"alpha3_code\" : \"STP\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Saudi Arabia\",\n" +
            "      \"alpha2_code\" : \"SA\",\n" +
            "      \"alpha3_code\" : \"SAU\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Senegal\",\n" +
            "      \"alpha2_code\" : \"SN\",\n" +
            "      \"alpha3_code\" : \"SEN\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Serbia\",\n" +
            "      \"alpha2_code\" : \"RS\",\n" +
            "      \"alpha3_code\" : \"SRB\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Seychelles\",\n" +
            "      \"alpha2_code\" : \"SC\",\n" +
            "      \"alpha3_code\" : \"SYC\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Sierra Leone\",\n" +
            "      \"alpha2_code\" : \"SL\",\n" +
            "      \"alpha3_code\" : \"SLE\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Singapore\",\n" +
            "      \"alpha2_code\" : \"SG\",\n" +
            "      \"alpha3_code\" : \"SGP\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Sint Maarten (Dutch part)\",\n" +
            "      \"alpha2_code\" : \"SX\",\n" +
            "      \"alpha3_code\" : \"SXM\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Slovakia\",\n" +
            "      \"alpha2_code\" : \"SK\",\n" +
            "      \"alpha3_code\" : \"SVK\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Slovenia\",\n" +
            "      \"alpha2_code\" : \"SI\",\n" +
            "      \"alpha3_code\" : \"SVN\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Solomon Islands\",\n" +
            "      \"alpha2_code\" : \"SB\",\n" +
            "      \"alpha3_code\" : \"SLB\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Somalia\",\n" +
            "      \"alpha2_code\" : \"SO\",\n" +
            "      \"alpha3_code\" : \"SOM\"\n" +
            "    }, {\n" +
            "      \"name\" : \"South Africa\",\n" +
            "      \"alpha2_code\" : \"ZA\",\n" +
            "      \"alpha3_code\" : \"ZAF\"\n" +
            "    }, {\n" +
            "      \"name\" : \"South Georgia and the South Sandwich Islands\",\n" +
            "      \"alpha2_code\" : \"GS\",\n" +
            "      \"alpha3_code\" : \"SGS\"\n" +
            "    }, {\n" +
            "      \"name\" : \"South Sudan\",\n" +
            "      \"alpha2_code\" : \"SS\",\n" +
            "      \"alpha3_code\" : \"SSD\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Spain\",\n" +
            "      \"alpha2_code\" : \"ES\",\n" +
            "      \"alpha3_code\" : \"ESP\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Sri Lanka\",\n" +
            "      \"alpha2_code\" : \"LK\",\n" +
            "      \"alpha3_code\" : \"LKA\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Sudan\",\n" +
            "      \"alpha2_code\" : \"SD\",\n" +
            "      \"alpha3_code\" : \"SDN\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Suriname\",\n" +
            "      \"alpha2_code\" : \"SR\",\n" +
            "      \"alpha3_code\" : \"SUR\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Svalbard and Jan Mayen\",\n" +
            "      \"alpha2_code\" : \"SJ\",\n" +
            "      \"alpha3_code\" : \"SJM\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Swaziland\",\n" +
            "      \"alpha2_code\" : \"SZ\",\n" +
            "      \"alpha3_code\" : \"SWZ\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Sweden\",\n" +
            "      \"alpha2_code\" : \"SE\",\n" +
            "      \"alpha3_code\" : \"SWE\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Switzerland\",\n" +
            "      \"alpha2_code\" : \"CH\",\n" +
            "      \"alpha3_code\" : \"CHE\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Syrian Arab Republic\",\n" +
            "      \"alpha2_code\" : \"SY\",\n" +
            "      \"alpha3_code\" : \"SYR\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Taiwan, Province of China [a]\",\n" +
            "      \"alpha2_code\" : \"TW\",\n" +
            "      \"alpha3_code\" : \"TWN\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Tajikistan\",\n" +
            "      \"alpha2_code\" : \"TJ\",\n" +
            "      \"alpha3_code\" : \"TJK\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Tanzania, United Republic of\",\n" +
            "      \"alpha2_code\" : \"TZ\",\n" +
            "      \"alpha3_code\" : \"TZA\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Thailand\",\n" +
            "      \"alpha2_code\" : \"TH\",\n" +
            "      \"alpha3_code\" : \"THA\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Timor-Leste\",\n" +
            "      \"alpha2_code\" : \"TL\",\n" +
            "      \"alpha3_code\" : \"TLS\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Togo\",\n" +
            "      \"alpha2_code\" : \"TG\",\n" +
            "      \"alpha3_code\" : \"TGO\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Tokelau\",\n" +
            "      \"alpha2_code\" : \"TK\",\n" +
            "      \"alpha3_code\" : \"TKL\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Tonga\",\n" +
            "      \"alpha2_code\" : \"TO\",\n" +
            "      \"alpha3_code\" : \"TON\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Trinidad and Tobago\",\n" +
            "      \"alpha2_code\" : \"TT\",\n" +
            "      \"alpha3_code\" : \"TTO\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Tunisia\",\n" +
            "      \"alpha2_code\" : \"TN\",\n" +
            "      \"alpha3_code\" : \"TUN\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Turkey\",\n" +
            "      \"alpha2_code\" : \"TR\",\n" +
            "      \"alpha3_code\" : \"TUR\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Turkmenistan\",\n" +
            "      \"alpha2_code\" : \"TM\",\n" +
            "      \"alpha3_code\" : \"TKM\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Turks and Caicos Islands\",\n" +
            "      \"alpha2_code\" : \"TC\",\n" +
            "      \"alpha3_code\" : \"TCA\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Tuvalu\",\n" +
            "      \"alpha2_code\" : \"TV\",\n" +
            "      \"alpha3_code\" : \"TUV\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Uganda\",\n" +
            "      \"alpha2_code\" : \"UG\",\n" +
            "      \"alpha3_code\" : \"UGA\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Ukraine\",\n" +
            "      \"alpha2_code\" : \"UA\",\n" +
            "      \"alpha3_code\" : \"UKR\"\n" +
            "    }, {\n" +
            "      \"name\" : \"United Arab Emirates\",\n" +
            "      \"alpha2_code\" : \"AE\",\n" +
            "      \"alpha3_code\" : \"ARE\"\n" +
            "    }, {\n" +
            "      \"name\" : \"United Kingdom of Great Britain and Northern Ireland\",\n" +
            "      \"alpha2_code\" : \"GB\",\n" +
            "      \"alpha3_code\" : \"GBR\"\n" +
            "    }, {\n" +
            "      \"name\" : \"United States of America\",\n" +
            "      \"alpha2_code\" : \"US\",\n" +
            "      \"alpha3_code\" : \"USA\"\n" +
            "    }, {\n" +
            "      \"name\" : \"United States Minor Outlying Islands\",\n" +
            "      \"alpha2_code\" : \"UM\",\n" +
            "      \"alpha3_code\" : \"UMI\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Uruguay\",\n" +
            "      \"alpha2_code\" : \"UY\",\n" +
            "      \"alpha3_code\" : \"URY\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Uzbekistan\",\n" +
            "      \"alpha2_code\" : \"UZ\",\n" +
            "      \"alpha3_code\" : \"UZB\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Vanuatu\",\n" +
            "      \"alpha2_code\" : \"VU\",\n" +
            "      \"alpha3_code\" : \"VUT\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Venezuela (Bolivarian Republic of)\",\n" +
            "      \"alpha2_code\" : \"VE\",\n" +
            "      \"alpha3_code\" : \"VEN\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Viet Nam\",\n" +
            "      \"alpha2_code\" : \"VN\",\n" +
            "      \"alpha3_code\" : \"VNM\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Virgin Islands (British)\",\n" +
            "      \"alpha2_code\" : \"VG\",\n" +
            "      \"alpha3_code\" : \"VGB\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Virgin Islands (U.S.)\",\n" +
            "      \"alpha2_code\" : \"VI\",\n" +
            "      \"alpha3_code\" : \"VIR\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Wallis and Futuna\",\n" +
            "      \"alpha2_code\" : \"WF\",\n" +
            "      \"alpha3_code\" : \"WLF\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Western Sahara\",\n" +
            "      \"alpha2_code\" : \"EH\",\n" +
            "      \"alpha3_code\" : \"ESH\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Yemen\",\n" +
            "      \"alpha2_code\" : \"YE\",\n" +
            "      \"alpha3_code\" : \"YEM\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Zambia\",\n" +
            "      \"alpha2_code\" : \"ZM\",\n" +
            "      \"alpha3_code\" : \"ZMB\"\n" +
            "    }, {\n" +
            "      \"name\" : \"Zimbabwe\",\n" +
            "      \"alpha2_code\" : \"ZW\",\n" +
            "      \"alpha3_code\" : \"ZWE\"\n" +
            "    } ]\n" +
            "  }\n" +
            "}";

    @Test
    public void canConvertJsonToResponse() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        CountryRestResponse record = mapper.readValue(new ByteArrayInputStream(RESPONSE.getBytes()), CountryRestResponse.class);
        List<CountryDTO> records = record.getRestResponse().getResult();
        Assert.assertEquals(249, records.size());
    }
}
