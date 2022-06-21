import { NativeModules, Platform, Linking } from 'react-native';

const LINKING_ERROR =
  `The package 'react-native-market-helper' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo managed workflow\n';

const MarketHelper = NativeModules.MarketHelper
  ? NativeModules.MarketHelper
  : new Proxy(
      {},
      {
        get() {
          throw new Error(LINKING_ERROR);
        },
      }
    );

export function open(appStoreId?: number): void {
  if (Platform.OS === 'ios') {
    const url = `itms-apps://itunes.apple.com/cn/app/id${appStoreId}?mt=8&action=write-review`;
    Linking.openURL(url).catch((err) =>
      console.error('An error occurred', err)
    );
  } else if (Platform.OS === 'android') {
    MarketHelper.open();
  }
}
