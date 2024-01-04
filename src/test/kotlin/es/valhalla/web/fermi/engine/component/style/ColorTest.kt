package es.valhalla.web.fermi.engine.component.style

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ColorTestSuite {
	@Nested
	internal inner class RgbaColorTest {
		@Test
		fun `RGBA color should fade correctly`() {
			val color = RgbaColor(100, 100, 100, 0.5f)
			val fadedColor = color.fade(20)

			assertEquals(0.6f, fadedColor.alpha, "Alpha value should be increased by 20%")
		}

		@Test
		fun `Completely faded RGBA color should stay at zero alpha`() {
			val color = RgbaColor(100, 100, 100, 0f)
			val fadedColor = color.fade(20)

			assertEquals(0.0f, fadedColor.alpha, "Alpha value should be increased by 20%")
		}

		@Test
		fun `RGBA color should darken correctly`() {
			val color = RgbaColor(150, 150, 150, 1f)
			val darkenedColor = color.darken(20)

			assertEquals(120, darkenedColor.red)
			assertEquals(120, darkenedColor.green)
			assertEquals(120, darkenedColor.blue)
			assertEquals(1f, darkenedColor.alpha)
		}

		@Test
		fun `RGBA color should convert to HexColorCode correctly`() {
			val color = RgbaColor(255, 0, 0, 1f)
			val hexColorCode = color.toHexColorCode()

			assertEquals("#FF0000FF", hexColorCode.toString(), "Hex string should match the RGBA color")
		}
	}

	@Nested
	internal inner class HexColorTest {
		@Test
		fun `Hex color should fade correctly`() {
			val hexColor = HexColor(HexColorCode.fromString("#FF000080"))
			val fadedHexColor = hexColor.fade(25)

			assertEquals("#FF0000A0", fadedHexColor.hexRepresentation.toString())
		}

		@Test
		fun `Hex color should darken correctly`() {
			val hexColor = HexColor(HexColorCode.fromString("#969696FF"))
			val darkenedHexColor: HexColor = hexColor.darken(20) as HexColor

			assertEquals("#787878FF", darkenedHexColor.hexRepresentation.toString())
		}

		@Test
		fun `Fading and darkening operations should be symmetrical between RGBA and HexColor`() {
			val rgbaColor = RgbaColor(100, 150, 200, 1f)
			val hexColor = HexColor(HexColorCode.fromString("#6496C8FF"))

			val fadedRgba = rgbaColor.fade(10)
			val fadedHex = hexColor.fade(10)
			assertEquals(fadedRgba.toHexColorCode().toString(), fadedHex.hexRepresentation.toString())

			val darkenedRgba = rgbaColor.darken(10)
			val darkenedHex = hexColor.darken(10) as HexColor
			assertEquals(darkenedRgba.toHexColorCode().toString(), darkenedHex.hexRepresentation.toString())
		}
	}

	@Nested
	internal inner class HexColorCodeTest {
		@Test
		fun `HexColorCode should be created correctly without alpha channel`() {
			val hexString = "#FF5733"
			val hexColorCode = HexColorCode.fromString(hexString)

			assertEquals(hexString, hexColorCode.toString())
		}

		@Test
		fun `HexColorCode should be created correctly with alpha channel`() {
			val hexString = "#FF5733AA"
			val hexColorCode = HexColorCode.fromString(hexString)

			assertEquals(hexString, hexColorCode.toString())
		}

		@Test
		fun `Invalid hex string should throw IllegalArgumentException`() {
			val invalidHexString = "#GGG999"

			val exception =
				assertThrows<IllegalArgumentException> {
					HexColorCode.fromString(invalidHexString)
				}

			assertTrue(exception.message?.contains("Invalid hex color code") ?: false)
		}
	}

	@Nested
	internal inner class ColorUtilsTest {
		@Test
		fun `Convert HexColorCode to RGBA components correctly`() {
			val hex = HexColorCode.fromString("#FF0000")
			val rgba = ColorUtils.hexToRgba(hex)

			assertAll(
				"Check each RGBA component",
				{ assertEquals(255, rgba.red) },
				{ assertEquals(0, rgba.green) },
				{ assertEquals(0, rgba.blue) },
				{ assertEquals(1f, rgba.alpha) },
			)
		}

		@Test
		fun `Convert RGBA components to HexColorCode correctly`() {
			val rgba = RgbaComponents(255, 0, 0, 1f)
			val hex = ColorUtils.rgbaToHex(rgba)

			assertEquals("#FF0000FF", hex.toString())
		}
	}
}
