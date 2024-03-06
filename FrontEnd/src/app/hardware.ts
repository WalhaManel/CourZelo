export class  Hardware {
    hardwareID: number;
    hardwareName: string;
    status: HardwareStatus;
    quantity: number;
}

export enum HardwareStatus {
    ACTIVE = 'ACTIVE',
    INACTIVE = 'INACTIVE',
    UNDER_REPAIR = 'UNDER_REPAIR'
}
